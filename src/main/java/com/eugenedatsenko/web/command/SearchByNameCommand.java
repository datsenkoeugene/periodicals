package com.eugenedatsenko.web.command;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.db.dao.PublicationDao;
import com.eugenedatsenko.db.entity.Publication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * SearchByNameCommand command.
 *
 * @author Y. Datsenko
 *
 */
public class SearchByNameCommand extends Command {

    private static final long serialVersionUID = 8478698557548121594L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String searchName = request.getParameter("name");
        PublicationDao publicationDao = new PublicationDao();
        Publication searchPublication = publicationDao.findPublicationsByName(searchName);
        List<Publication> allPublicationsList = publicationDao.findAllPublications();
        request.setAttribute("allPublicationsList", allPublicationsList);
        request.setAttribute("searchPublication", searchPublication);
        request.setAttribute("path", request.getParameter("page"));
        return Path.PAGE_SEARCH_PUBLICATIONS;
    }
}
