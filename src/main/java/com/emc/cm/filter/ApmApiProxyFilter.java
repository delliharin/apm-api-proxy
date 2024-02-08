package com.emc.cm.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@Component
public class ApmApiProxyFilter implements Filter {
    Logger LOGGER = LoggerFactory.getLogger(ApmApiProxyFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("[ApmApiProxy] - Inside doFilter method");
        LOGGER.info("Local Port : " + request.getLocalPort());
        LOGGER.info("Server Name : " + request.getServerName());

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        LOGGER.info("Method Name : " + httpServletRequest.getMethod());
        LOGGER.info("Request URI : " + httpServletRequest.getRequestURI());
        LOGGER.info("Servlet Path : " + httpServletRequest.getServletPath());
        chain.doFilter(request, response);
    }
}
