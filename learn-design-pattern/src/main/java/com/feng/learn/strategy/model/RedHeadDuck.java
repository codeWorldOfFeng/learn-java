package com.feng.learn.strategy.model;

import com.feng.learn.strategy.strategy.FlyWithWings;

public class RedHeadDuck extends Duck {

	{
		this.flyBehavior = new FlyWithWings();
	}
	
	@Override
	public void display() {
		System.out.println("a redHead duck");
	}

}
