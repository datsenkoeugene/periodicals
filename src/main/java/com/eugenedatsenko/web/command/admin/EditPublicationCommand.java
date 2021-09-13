package com.eugenedatsenko.web.command.admin;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.db.dao.PublicationDao;
import com.eugenedatsenko.db.entity.Publication;
import com.eugenedatsenko.web.command.Command;
import com.eugenedatsenko.web.command.authorization.LoginCommand;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * EditPublicationCommand command.
 *
 * @author Y. Datsenko
 *
 */
public class EditPublicationCommand extends Command {

    private static final long serialVersionUID = -5110905009841588781L;

    private static final Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int publicationId = Integer.parseInt(request.getParameter("id"));
        PublicationDao publicationDao = new PublicationDao();
        Publication publication = publicationDao.findPublicationById(publicationId);
        request.setAttribute("publication", publication);
        return Path.PAGE_EDIT_PUBLICATION;
    }
}
