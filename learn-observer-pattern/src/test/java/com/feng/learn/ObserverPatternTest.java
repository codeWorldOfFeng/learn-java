package com.feng.learn;

import org.junit.Test;

import com.feng.learn.listener.ListenerOne;
import com.feng.learn.listener.ListenerTwo;
import com.feng.learn.model.HttpSession;

public class ObserverPatternTest {

    @Test
    public void test() {
	HttpSession session = new HttpSession();

	ListenerOne one = new ListenerOne();
	ListenerTwo two = new ListenerTwo();

	session.addListener(one);
	session.addListener(two);

	session.create();

	session.destroy();
    }
}
