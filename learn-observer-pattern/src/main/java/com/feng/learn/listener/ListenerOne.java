/**
 * 
 */
package com.feng.learn.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feng.learn.event.HttpSessionEvent;

/**
 * @author feng_Pc
 *
 */
public class ListenerOne implements HttpSessionListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sessionCreated(HttpSessionEvent event) {
	logger.debug("linstenOne get nofity(create): {}", event.getSource());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
	logger.debug("linstenOne get nofity(destroy): {}", event.getSource());
    }

}
