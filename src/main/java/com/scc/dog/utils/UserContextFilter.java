package com.scc.dog.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

@Component
public class UserContextFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String authToken = httpServletRequest.getHeader(UserContext.AUTH_TOKEN);
        String authKey = httpServletRequest.getHeader(UserContext.AUTHENTICATION_KEY);

        UserContextHolder.getContext().setAuthentificationKey(authKey);
        UserContextHolder.getContext().setAuthToken(authToken);

        logger.debug("Incoming Authentification key: {}", authKey);
        filterChain.doFilter(httpServletRequest, servletResponse);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

}