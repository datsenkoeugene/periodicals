package com.eugenedatsenko.web.command;

import com.eugenedatsenko.Path;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LanguageCommand extends Command {

    private static final long serialVersionUID = -2935482885989372540L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getParameter("path");
        String forward = Path.PAGE_ERROR_PAGE;

        if (path.equals("login")) {
            request.getSession().setAttribute("lang", request.getParameter("lang"));
            forward = Path.PAGE_LOGIN;
        }

        if (path.equals("register")) {
            request.getSession().setAttribute("lang", request.getParameter("lang"));
            forward = Path.PAGE_REGISTER;
        }
        return forward;
    }
}
