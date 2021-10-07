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

/**
 * SortPublicationsByName command.
 *
 * @author Y. Datsenko
 *
 */
public class SortPublicationsByName extends Command {

    private static final long serialVersionUID = -7243689465930683928L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String spageid = (String) session.getAttribute("currentPage");
        int pageid = Integer.parseInt(spageid);
        int total = 3;
        if (pageid == 1) {
        } else {
            pageid = pageid - 1;
            pageid = pageid * total + 1;
        }
        session.setAttribute("sorted", "byName");
        PublicationDao publicationDao = new PublicationDao();
        List<Publication> allPublicationsList = publicationDao.findAllPublications();
        List<Publication> publicationListByName = publicationDao.getRecordsByName(pageid, total);
        request.setAttribute("publicationsList", publicationListByName);
        request.setAttribute("allPublicationsList", allPublicationsList);
        return Path.PAGE_PERIODICALS_LIST;
    }
}
