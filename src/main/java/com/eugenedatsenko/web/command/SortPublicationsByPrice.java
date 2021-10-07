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
 * SortPublicationsByPrice command.
 *
 * @author Y. Datsenko
 *
 */
public class SortPublicationsByPrice extends Command {

    private static final long serialVersionUID = 2013173276502205851L;

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
        session.setAttribute("sorted", "byPrice");
        PublicationDao publicationDao = new PublicationDao();
        List<Publication> allPublicationsList = publicationDao.findAllPublications();
        List<Publication> publicationListByName = publicationDao.getRecordsByPrice(pageid, total);
        request.setAttribute("publicationsList", publicationListByName);
        request.setAttribute("allPublicationsList", allPublicationsList);
        return Path.PAGE_PERIODICALS_LIST;
    }
}
