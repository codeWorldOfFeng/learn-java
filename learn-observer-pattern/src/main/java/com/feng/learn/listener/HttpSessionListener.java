package com.feng.learn.listener;

import com.feng.learn.event.HttpSessionEvent;

public interface HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event);

    public void sessionDestroyed(HttpSessionEvent event);

}
