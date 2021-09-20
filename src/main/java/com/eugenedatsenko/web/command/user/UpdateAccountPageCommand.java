package com.eugenedatsenko.web.command.user;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.web.command.Command;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateAccountPageCommand extends Command {

    private static final long serialVersionUID = 2328292746828264168L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        return Path.PAGE_USER_UPDATE_ACCOUNT_PAGE;
    }
}
