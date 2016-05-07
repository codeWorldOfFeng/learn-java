package com.feng.learn.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feng.learn.event.HttpSessionEvent;
import com.feng.learn.listener.HttpSessionListener;

public class HttpSession {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<HttpSessionListener> listeners;

    {
	listeners = new ArrayList<HttpSessionListener>(2);
    }

    public void addListener(HttpSessionListener listener) {
	listeners.add(listener);
    }

    public void removeListener(HttpSessionListener listener) {
	listeners.remove(listener);
    }

    private HttpSessionEvent createEvent() {
	return new HttpSessionEvent(this);
    }

    private void notifyAllListenersOfCreate(HttpSessionEvent event) {
	for (HttpSessionListener listener : listeners) {
	    listener.sessionCreated(event);
	}
    }

    private void notifyAllListenersOfDestroy(HttpSessionEvent event) {
	for (HttpSessionListener listener : listeners) {
	    listener.sessionDestroyed(event);
	}
    }

    public void create() {
	logger.debug("httpSession create start");
	HttpSessionEvent event = createEvent();
	notifyAllListenersOfCreate(event);
	logger.debug("httpSession create end");
    }

    public void destroy() {
	logger.debug("httpSession destroy start");
	HttpSessionEvent event = createEvent();
	notifyAllListenersOfDestroy(event);
	logger.debug("httpSession destroy end");
    }

}
