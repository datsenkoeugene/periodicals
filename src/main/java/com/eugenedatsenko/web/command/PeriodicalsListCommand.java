package com.eugenedatsenko.web.command;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.db.dao.PublicationDao;
import com.eugenedatsenko.db.entity.Publication;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PeriodicalsListCommand extends Command {

    private static final long serialVersionUID = -6768362974738160278L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PublicationDao publicationDao = new PublicationDao();
        List<Publication> publicationsList = publicationDao.findAllPublications();
        request.setAttribute("publicationsList", publicationsList);
        return Path.PAGE_PERIODICALS_LIST;
    }
}
