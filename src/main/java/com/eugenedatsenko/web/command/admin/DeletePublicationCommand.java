package com.eugenedatsenko.web.command.admin;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.db.dao.PublicationDao;
import com.eugenedatsenko.db.entity.Publication;
import com.eugenedatsenko.web.command.Command;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * DeletePublicationCommand command.
 *
 * @author Y. Datsenko
 *
 */
public class DeletePublicationCommand extends Command {

    private static final long serialVersionUID = -1220702015179237244L;

    private static final Logger log = Logger.getLogger(DeletePublicationCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");
        int publicationId = Integer.parseInt(request.getParameter("id"));
        PublicationDao publicationDao = new PublicationDao();
        publicationDao.deletePublication(publicationId);
        List<Publication> publicationsList = publicationDao.getRecords(1, 3);
        List<Publication> allPublicationsList = publicationDao.findAllPublications();
        request.setAttribute("publicationsList", publicationsList);
        request.setAttribute("allPublicationsList", allPublicationsList);
        log.debug("Command finished");
        return Path.COMMAND_PERIODICALS_LIST + "&page=1";
    }
}
