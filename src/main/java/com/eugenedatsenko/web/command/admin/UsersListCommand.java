package com.eugenedatsenko.web.command.admin;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.db.dao.UserDao;
import com.eugenedatsenko.db.entity.User;
import com.eugenedatsenko.web.command.Command;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * UsersListCommand command.
 *
 * @author Y. Datsenko
 *
 */
public class UsersListCommand extends Command {

    private static final long serialVersionUID = -7278111555539526137L;

    private static final Logger log = Logger.getLogger(UsersListCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");
        UserDao userDao = new UserDao();
        List<User> userList = userDao.findAllUsers();
        request.setAttribute("usersList", userList);
        log.debug("Command finished");
        return Path.PAGE_USERS_LIST;
    }
}
