package com.eugenedatsenko.web.command;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.db.dao.PublicationDao;
import com.eugenedatsenko.db.entity.Publication;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class PeriodicalsListCommand extends Command {

    private static final long serialVersionUID = -6768362974738160278L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String spageid = request.getParameter("page");
        HttpSession session = request.getSession();
        session.setAttribute("currentPage", spageid);
        String sorted = (String) session.getAttribute("sorted");
        int pageid = Integer.parseInt(spageid);
        int total = 3;
        PublicationDao publicationDao = new PublicationDao();
        List<Publication> publicationsList = publicationDao.getRecords(pageid, total);
        List<Publication> allPublicationsList = publicationDao.findAllPublications();
        request.setAttribute("publicationsList", publicationsList);
        request.setAttribute("allPublicationsList", allPublicationsList);
        if (pageid == 1) {
        } else {
            pageid = pageid - 1;
            pageid = pageid * total + 1;
        }
        if (sorted == null) {
            return Path.PAGE_PERIODICALS_LIST;
        }

        if (sorted.equals("byPrice")) {
            return Path.COMMAND_SORT_PUBLICATION_BY_PRICE;
        }

        if (sorted.equals("byName")) {
            return Path.COMMAND_SORT_PUBLICATION_BY_NAME;
        }
        return Path.PAGE_PERIODICALS_LIST;
    }
}
