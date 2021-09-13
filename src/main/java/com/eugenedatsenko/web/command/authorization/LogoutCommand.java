package com.eugenedatsenko.web.command.authorization;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.web.command.Command;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Logout command.
 *
 * @author Y. Datsenko
 *
 */
public class LogoutCommand extends Command {

    private static final long serialVersionUID = 6596301798409846025L;

    private static final Logger log = Logger.getLogger(LogoutCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        log.debug("Command finished");
        return Path.PAGE_LOGIN;
    }
}
