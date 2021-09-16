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
import java.math.BigDecimal;
import java.util.List;

/**
 * InsertPublicationCommand command.
 *
 * @author Y. Datsenko
 *
 */
public class InsertPublicationCommand extends Command {

    private static final long serialVersionUID = 6363500153565524108L;

    private static final Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        log.debug("Command starts");
        String name = request.getParameter("name");
        log.trace("Request parameter: email --> " + name);
        String theme = request.getParameter("theme");
        log.trace("Request parameter: email --> " + theme);
        BigDecimal price = new BigDecimal(Integer.parseInt(request.getParameter("price")));
        log.trace("Request parameter: email --> " + price);

        Publication newPublication = new Publication();
        String errorName = null;
        String errorTheme = null;
        String errorPrice = null;
        String forward = Path.PAGE_ERROR_PAGE;

        if (name == null || name.isEmpty()) {
            errorName = "Name cannot be empty.";
            request.setAttribute("errorName", errorName);
            request.setAttribute("name", name);
            request.setAttribute("theme", theme);
            request.setAttribute("price", price);
            log.error("errorMessage --> " + errorName);
            forward = Path.PAGE_INSERT_PUBLICATION;
            return forward;
        }

        if (theme == null || theme.isEmpty()) {
            errorTheme = "Theme cannot be empty.";
            request.setAttribute("errorTheme", errorTheme);
            request.setAttribute("name", name);
            request.setAttribute("theme", theme);
            request.setAttribute("price", price);
            log.error("errorMessage --> " + errorTheme);
            forward = Path.PAGE_INSERT_PUBLICATION;
            return forward;
        }

        if (price.intValue() == 0) {
            errorPrice = "The price shouldn't be 0.";
            request.setAttribute("errorPrice", errorPrice);
            request.setAttribute("name", name);
            request.setAttribute("theme", theme);
            request.setAttribute("price", price);
            log.error("errorMessage --> " + errorPrice);
            forward = Path.PAGE_INSERT_PUBLICATION;
            return forward;
        }

        PublicationDao publicationDao = new PublicationDao();
        newPublication.setName(name);
        newPublication.setTheme(theme);
        newPublication.setPrice(price);
        publicationDao.insertPublication(newPublication);
        List<Publication> publicationList = publicationDao.findAllPublications();
        request.setAttribute("publicationList", publicationList);
        return Path.COMMAND_PERIODICALS_LIST + "&page=1";
    }
}
