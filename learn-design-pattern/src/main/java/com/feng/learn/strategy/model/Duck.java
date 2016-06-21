package com.feng.learn.strategy.model;

import com.feng.learn.strategy.strategy.FlyBehavior;
import com.feng.learn.strategy.strategy.QuackBehavior;

public abstract class Duck {
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;

	public void swim() {
		System.out.println("A duck is swimming.");
	}

	public void fly() {
		flyBehavior.fly();
	}

	public void quack() {
		quackBehavior.quack();
	}

	public abstract void display();

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

}
