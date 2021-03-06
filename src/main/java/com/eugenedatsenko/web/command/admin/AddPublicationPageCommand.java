package com.eugenedatsenko.web.command.admin;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.web.command.Command;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AddPublicationPageCommand command.
 *
 * @author Y. Datsenko
 *
 */
public class AddPublicationPageCommand extends Command {

    private static final long serialVersionUID = 7647155338287385275L;

    private static final Logger log = Logger.getLogger(AddPublicationPageCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");
        log.debug("Command finished");
        return Path.PAGE_INSERT_PUBLICATION;
    }
}
