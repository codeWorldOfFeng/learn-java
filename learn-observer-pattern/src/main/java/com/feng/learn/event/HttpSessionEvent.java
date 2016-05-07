package com.feng.learn.event;

import com.feng.learn.model.HttpSession;

public class HttpSessionEvent extends java.util.EventObject {

    public HttpSessionEvent(HttpSession source) {
	super(source);
    }

    @Override
    public HttpSession getSource() {
	return (HttpSession) super.getSource();
    }

}
