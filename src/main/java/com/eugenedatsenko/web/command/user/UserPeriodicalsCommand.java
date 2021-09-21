package com.eugenedatsenko.web.command.user;

import com.eugenedatsenko.Path;
import com.eugenedatsenko.web.command.Command;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserPeriodicalsCommand extends Command {

    private static final long serialVersionUID = 493220617070787373L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        return Path.PAGE_USER_PERIODICALS;
    }
}
