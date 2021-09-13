package com.eugenedatsenko.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Encoding filter.
 *
 * @author Y.Datsenko
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

    private static final Logger log = Logger.getLogger(EncodingFilter.class);

    private String encoding = "UTF-8";

    public void init(FilterConfig config) throws ServletException {
        log.debug("Filter initialization starts");
        log.debug("Filter initialization finished");
    }

    public void destroy() {
        log.debug("Filter destruction starts");
        log.debug("Filter destruction finished");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        log.debug("Filter starts");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        log.trace("Request uri --> " + httpRequest.getRequestURI());
        String requestEncoding = request.getCharacterEncoding();
        if (requestEncoding == null) {
            log.trace("Request encoding = null, set encoding --> " + encoding);
            request.setCharacterEncoding(encoding);
        }
        log.debug("Filter finished");
        chain.doFilter(request, response);
    }
}

