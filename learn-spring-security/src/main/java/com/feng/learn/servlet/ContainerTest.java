package com.feng.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContainerTest extends HttpServlet {

    static {
	System.out.println("servlet.classLoad()");
    }

    public ContainerTest() {
	System.out.println("servlet.construtor()");
    }

    @Override
    public void destroy() {
	System.out.println("servlet.destroy()");
    }

    @Override
    public void init() throws ServletException {
	System.out.println("servlet.init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	System.out.println("Hello World");
	resp.setContentType("text/html;charset=UTF-8");
	resp.getWriter().print("Servlet 容器测试 success..");
    }

}
