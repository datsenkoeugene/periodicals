package com.eugenedatsenko.web.command.user;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.db.dao.AccountDao;
import com.eugenedatsenko.db.entity.Account;
import com.eugenedatsenko.web.command.Command;
import com.eugenedatsenko.web.command.authorization.LoginCommand;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * UserAccountCommand command.
 *
 * @author Y. Datsenko
 *
 */
public class UserAccountCommand extends Command {

    private static final long serialVersionUID = -151107147399121574L;

    private static final Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");
        AccountDao accountDao = new AccountDao();
        List<Account> accountList = accountDao.findAllAccounts(Integer.parseInt(request.getParameter("userId")));
        request.setAttribute("accountList", accountList);
        log.debug("Command finished");
        return Path.PAGE_USER_ACCOUNT;
    }
}
