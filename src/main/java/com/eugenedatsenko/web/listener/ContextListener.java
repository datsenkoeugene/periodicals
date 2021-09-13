package com.eugenedatsenko.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Context listener.
 *
 * @author Y. Datsenko
 */
@WebListener
public class ContextListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(ContextListener.class);

    public void contextDestroyed(ServletContextEvent event) {
        log.debug("Servlet context destruction starts");
        log.debug("Servlet context destruction finished");
    }

    /**
     * Initializes log4j framework.
     *
     * @param servletContext
     */
    private void initLog4J(ServletContext servletContext) {
        log.debug("Log4J initialization started");
        try {
            PropertyConfigurator.configure(servletContext.getRealPath("WEB-INF/log4j.properties"));
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Log4j error ", ex);
        }
        log.debug("Log4J initialization finished");
    }

    public void contextInitialized(ServletContextEvent event) {
        log.debug("Servlet context initialization starts");
        ServletContext servletContext = event.getServletContext();
        initLog4J(servletContext);
        log.debug("Servlet context initialization finished");
    }
}
