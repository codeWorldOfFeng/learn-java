package com.feng.learn.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContainerTest extends HttpServlet {
    protected static Logger logger = LoggerFactory.getLogger(ContainerTest.class);
    static {
	logger.debug("servlet.{}()", "classLoad");
    }

    public ContainerTest() {
	logger.debug("servlet.construtor()");
    }

    @Override
    public void destroy() {
	logger.debug("servlet.destroy()");
    }

    @Override
    public void init() throws ServletException {
	logger.debug("servlet.init()");
	Enumeration<String> initNames = this.getInitParameterNames();
	while (initNames.hasMoreElements()) {
	    String name = initNames.nextElement();
	    String value = this.getInitParameter(name);
	    logger.debug("Servlet.init({}) = {}", name, value);
	}
	logger.debug("servlet.init() end");
    }

    @Override
    // /test/test
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	logger.debug("service start ..");
	// testServletContext();
	// testRedirect(resp);
	testRequestDispatcher(req, resp);
	resp.setContentType("text/html;charset=UTF-8");
	resp.getWriter().print("Servlet 容器测试 success..");
	logger.debug("service end ..");
    }

    /**
     * request.getRequestDispatcher()
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void testRequestDispatcher(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
	requestDispatcher.forward(req, resp);
    }

    /*
     * response.sendRedirect()
     */
    private void testRedirect(HttpServletResponse resp) throws IOException {
	// resp.sendRedirect("http://www.baidu.com"); //绝对地址
	// resp.sendRedirect("/hello"); // 相对于容器的地址 127.0.0.1:8080/hello
	resp.sendRedirect("hello");// 相对于当前url的地址 如果当前地址为
				   // 127.0.0.1:8080/jetty/test/test 目的地址为
				   // 127.0.0.1:8080/jetty/test/hello
    }

    /**
     * ServletContext
     * 
     * @throws MalformedURLException
     */
    private void testServletContext() throws MalformedURLException {
	logger.debug("ServletContext info start");

	ServletContext context = getServletContext();
	context.setAttribute("feng", "zhangzhanfeng");
	Enumeration<String> attrNames = context.getAttributeNames();
	while (attrNames.hasMoreElements()) {
	    String attrName = attrNames.nextElement();
	    Object attrValue = context.getAttribute(attrName);
	    logger.debug("ServletContext.getAttribute({}) = {}", attrName, attrValue);
	}

	String contextPath = context.getContextPath();
	logger.debug("contextPath: {}", contextPath);

	Enumeration<String> initNames = context.getInitParameterNames();
	while (initNames.hasMoreElements()) {
	    String name = initNames.nextElement();
	    String value = context.getInitParameter(name);
	    logger.debug("ServletContext.getInitParameter({}) = {}", name, value);
	}

	String realPath = context.getRealPath("/index.html");
	logger.debug("realPath: {}", realPath);

	URL resourceUrl = context.getResource("/index.jsp");
	logger.debug("resourceUrl: {}", resourceUrl);

	InputStream ris = context.getResourceAsStream("/index.jsp");

	logger.debug("ServletContext info end");
    }
}
