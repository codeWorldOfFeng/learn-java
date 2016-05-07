package com.feng.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpSessionTest extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	logger.debug("servletId: {}", this);
	HttpSession session = req.getSession();
	logger.info("sessionId: {}", session.getId());
	logger.debug("sessionIsNew: {}", session.isNew());
	logger.debug("sessionLastAccessTime: {}", session.getLastAccessedTime());
	logger.debug("sessionMaxInactiveInterval: {}", session.getMaxInactiveInterval());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doPost(req, resp);
    }

}
