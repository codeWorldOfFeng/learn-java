package com.feng.learn.servlet;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttrTest extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ServletConfig servletConfig = getServletConfig();
	logger.debug("servletName: {}", servletConfig.getServletName());
	logger.debug("servletContext: {}", servletConfig.getServletContext());
	logger.debug("servletParamNames: {}", Collections.list(servletConfig.getInitParameterNames()));
	logger.debug("characterEncoding: {}", resp.getCharacterEncoding());
	resp.getWriter().println("attrTest");
	resp.getWriter().flush();
	throw new RuntimeException("TEsaskjdflk;jsl;");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
