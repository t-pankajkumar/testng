package com.selinium;

public class NewTesting {
	public static void main(String args[]) {
		System.out.println("Hello world");
		NewTesting newtesting = new NewTesting();
		System.out.println(newtesting.sayHello());
	}
	
	public String sayHello() {
		return "Hello";
	}
}
