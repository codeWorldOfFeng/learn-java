package com.feng.learn.strategy.strategy;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("fly no way.");
	}

}
