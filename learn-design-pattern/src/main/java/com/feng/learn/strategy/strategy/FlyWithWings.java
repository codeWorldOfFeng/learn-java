package com.feng.learn.strategy.strategy;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("fly with wings.");
	}

}
