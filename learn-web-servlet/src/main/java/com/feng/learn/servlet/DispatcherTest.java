package com.feng.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DispatcherTest extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	logger.debug("dispatcherTest doGet() start");
	try {
	    logger.debug("username: {}", req.getParameter("username"));
	    resp.sendRedirect("/jetty/jsp/dd.jsp?username=feng");
	} catch (Exception e) {
	    logger.debug(e.toString());
	}
	resp.getWriter().println("dispatcherTest");
	logger.debug("dispatcherTest doGet() end");
    }

}
