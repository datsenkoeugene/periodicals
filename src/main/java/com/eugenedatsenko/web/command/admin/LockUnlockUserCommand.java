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
 * LockUnlockUserCommand command.
 *
 * @author Y. Datsenko
 *
 */
public class LockUnlockUserCommand extends Command {

    private static final long serialVersionUID = 8692758184138109748L;

    private static final Logger log = Logger.getLogger(LockUnlockUserCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.findUserById(userId);
        user.setLock(!user.getLock());
        userDao.updateUser(user);
        List<User> usersList = userDao.findAllUsers();
        request.setAttribute("usersList", usersList);
        log.debug("Command finished");
        return Path.PAGE_USERS_LIST;
    }
}
