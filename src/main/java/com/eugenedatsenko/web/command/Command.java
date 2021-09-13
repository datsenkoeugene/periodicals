package com.eugenedatsenko.web.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Main interface for the Command pattern implementation.
 *
 * @author Y. Datsenko
 *
 */
public abstract class Command implements Serializable {

    private static final long serialVersionUID = -8496712775775229358L;

    public abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException;

    @Override
    public final String toString() {
        return getClass().getSimpleName();
    }
}
