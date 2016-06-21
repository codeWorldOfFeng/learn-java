package com.feng.learn.strategy.model;

import com.feng.learn.strategy.strategy.FlyNoWay;

public class RubberDuck extends Duck {

	{
		this.flyBehavior = new FlyNoWay();
	}
	
	@Override
	public void display() {
		System.out.println("a rubberDuck.");
	}

}
