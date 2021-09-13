package com.eugenedatsenko.web.command.authorization;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.db.dao.UserDao;
import com.eugenedatsenko.db.entity.User;
import com.eugenedatsenko.util.SecurePasswordMD5;
import com.eugenedatsenko.web.command.Command;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Register command.
 *
 * @author Y. Datsenko
 *
 */
public class RegisterCommand extends Command {

    private static final long serialVersionUID = 269093901966077688L;

    private static final Logger log = Logger.getLogger(RegisterCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        String errorMessage = null;
        String errorEmail = null;
        String errorFirstName = null;
        String errorLastname = null;
        String errorPassword = null;
        String forward = Path.PAGE_ERROR_PAGE;

        if (email == null || email.isEmpty()) {
            errorEmail = "Email cannot be empty.";
            request.setAttribute("errorEmail", errorEmail);
            request.setAttribute("email", email);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("password", password);
            log.error("errorMessage --> " + errorEmail);
            forward = Path.PAGE_REGISTER;
            return forward;
        }

        if (firstName == null || firstName.isEmpty()) {
            errorFirstName = "First Name cannot be empty.";
            request.setAttribute("errorFirstName", errorFirstName);
            request.setAttribute("email", email);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("password", password);
            log.error("errorMessage --> " + errorFirstName);
            forward = Path.PAGE_REGISTER;
            return forward;
        }

        if (lastName == null || lastName.isEmpty()) {
            errorLastname = "Last Name cannot be empty.";
            request.setAttribute("errorLastname", errorLastname);
            request.setAttribute("email", email);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("password", password);
            log.error("errorMessage --> " + errorLastname);
            forward = Path.PAGE_REGISTER;
            return forward;
        }

        if (password == null || password.isEmpty()) {
            errorPassword = "Minimum password length 6 characters.";
            request.setAttribute("errorPassword", errorPassword);
            request.setAttribute("email", email);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("password", password);
            log.error("errorMessage --> " + errorPassword);
            forward = Path.PAGE_REGISTER;
            return forward;
        }

        User candidate = new UserDao().findUserByEmail(email);
        log.trace("Found in DB: user --> " + candidate);

        if (candidate != null) {
            errorMessage = "User with email already exists.";
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("email", email);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("password", password);
            log.error("errorMessage --> " + errorMessage);
            forward = Path.PAGE_REGISTER;
            return forward;
        } else {
            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(SecurePasswordMD5.getSecurePassword(password));
            user.setLock(false);
            user.setRoleId(2);
            UserDao userDao = new UserDao();
            userDao.insertUser(user);
            log.debug("Command finished");
            return Path.PAGE_LOGIN;
        }
    }
}
