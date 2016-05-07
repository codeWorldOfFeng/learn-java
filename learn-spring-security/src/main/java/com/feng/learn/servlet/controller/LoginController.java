package com.feng.learn.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    /**
     * 
     * @param req
     * @param resp
     * @param username
     * @param password
     * @throws IOException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest req, HttpServletResponse resp,
	    String username, String password) throws IOException {
	resp.setContentType("text/plain;charset=utf-8");
	PrintWriter out = resp.getWriter();
	if (check(username, password)) {
	    out.print("login succeed..");
	} else {
	    out.print("login failed..");
	}
    }

    /**
     * 
     * @param username
     * @param password
     * @return
     */
    private boolean check(String username, String password) {
	return true;
    }
}
