package com.eugenedatsenko.web.command.authorization;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.db.Role;
import com.eugenedatsenko.db.dao.UserDao;
import com.eugenedatsenko.db.entity.User;
import com.eugenedatsenko.util.SecurePasswordMD5;
import com.eugenedatsenko.web.command.Command;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 * Login command.
 *
 * @author Y. Datsenko
 *
 */
public class LoginCommand extends Command {

    private static final long serialVersionUID = 6931415914744058091L;

    private static final Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        log.trace("Request parameter: email --> " + email);
        String password = request.getParameter("password");
        String errorMessage = null;
        String errorEmail = null;
        String errorPassword = null;
        String forward = Path.PAGE_ERROR_PAGE;

        if (email == null || email.isEmpty()) {
            errorEmail = "Email cannot be empty.";
            request.setAttribute("errorEmail", errorEmail);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            log.error("errorMessage --> " + errorEmail);
            forward = Path.PAGE_LOGIN;
            return forward;
        }

        if (password == null || password.isEmpty()) {
            errorPassword = "Minimum password length 6 characters.";
            request.setAttribute("errorPassword", errorPassword);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            log.error("errorMessage --> " + errorPassword);
            forward = Path.PAGE_LOGIN;
            return forward;
        }

        User user = new UserDao().findUserByEmail(email);
        log.trace("Found in DB: user --> " + user);

        if (user == null || !SecurePasswordMD5.verifyPassword(password, user.getPassword())) {
            errorMessage = "Cannot find user with such login/password";
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            log.error("errorMessage --> " + errorMessage);
            forward = Path.PAGE_LOGIN;
            return forward;
        } else {
            Role userRole = Role.getRole(user);
            log.trace("userRole --> " + userRole);

            if (userRole == Role.ADMIN) {
                forward = Path.COMMAND_PERIODICALS_LIST + "&page=1";
            }

            if (userRole == Role.USER) {
                forward = Path.COMMAND_PERIODICALS_LIST + "&page=1";
            }
            session.setAttribute("user", user);
            log.trace("Set the session attribute: user --> " + user);
            session.setAttribute("userRole", userRole);
            log.trace("Set the session attribute: userRole --> " + userRole);
            log.info("User " + user + " logged as " + userRole.toString().toLowerCase());
        }
        log.debug("Command finished");
        return forward;
    }
}

