package com.feng.learn.strategy.model;

public class Test {
	public static void main(String args[]) {
		Duck d = new MallardDuck();
		d.fly();
		d = new RubberDuck();
		d.fly();
	}
}
