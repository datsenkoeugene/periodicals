package com.eugenedatsenko.web.command;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.db.dao.PublicationDao;
import com.eugenedatsenko.db.entity.Publication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SortPublicationsByNameASCCommand extends Command {

    private static final long serialVersionUID = -7243689465930683928L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PublicationDao publicationDao = new PublicationDao();
        List<Publication> publicationListByName = publicationDao.getRecordsByName(1, 3);
        System.out.println("############# " + publicationListByName);
        List<Publication> allPublicationsList = publicationDao.findAllPublications();
        request.setAttribute("publicationsList", publicationListByName);
        request.setAttribute("allPublicationsList", allPublicationsList);
        return Path.PAGE_PERIODICALS_LIST;
    }
}
