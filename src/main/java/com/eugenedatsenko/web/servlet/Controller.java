package com.eugenedatsenko.web.servlet;

import com.eugenedatsenko.web.command.Command;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.eugenedatsenko.web.command.CommandContainer;
import org.apache.log4j.Logger;

/**
 * Main servlet controller.
 *
 * @author Y. Datsenko
 *
 */
@WebServlet(name = "Controller", value = "/controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = -6268814830384980473L;

    private static final Logger log = Logger.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    /**
     * Main method of this controller.
     */
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("Controller starts");
        String commandName = request.getParameter("command");
        log.trace("Request parameter: command --> " + commandName);
        Command command = CommandContainer.get(commandName);
        log.trace("Obtained command --> " + command);
        String forward = command.execute(request, response);
        log.trace("Forward address --> " + forward);
        log.debug("Controller finished, now go to forward address --> " + forward);
        if (forward != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
            requestDispatcher.forward(request, response);
        }
    }
}

