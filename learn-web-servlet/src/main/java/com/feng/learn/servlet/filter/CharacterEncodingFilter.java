package com.feng.learn.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharacterEncodingFilter implements Filter {

    private FilterConfig config;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
	this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {

	logger.debug("CharacterEncodingFilter-characterEncoding1: {}", response.getCharacterEncoding());
	String encoding = config.getInitParameter("encoding");
	response.setCharacterEncoding(encoding);
	logger.debug("CharacterEncodingFilter-characterEncoding2: {}", response.getCharacterEncoding());
	chain.doFilter(request, response);

	HttpServletResponse resp = (HttpServletResponse) response;
	resp.addHeader("characterEncoding", encoding);
    }

    @Override
    public void destroy() {
	// TODO Auto-generated method stub

    }

}
