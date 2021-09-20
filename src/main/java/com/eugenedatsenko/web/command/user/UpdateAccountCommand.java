package com.eugenedatsenko.web.command.user;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.db.dao.AccountDao;
import com.eugenedatsenko.db.entity.Account;
import com.eugenedatsenko.web.command.Command;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class UpdateAccountCommand extends Command {

    private static final long serialVersionUID = 2328292746828264168L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountDao accountDao = new AccountDao();
        Account account = accountDao.findAccountById(Integer.parseInt(request.getParameter("userId")));
        account.setAmount(new BigDecimal(request.getParameter("amount")).add(account.getAmount()));
        accountDao.updateAccount(account);
        List<Account> accountList = accountDao.findAllAccounts(Integer.parseInt(request.getParameter("userId")));
        request.setAttribute("accountList", accountList);
        return Path.PAGE_USER_ACCOUNT;
    }
}
