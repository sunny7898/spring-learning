package com.springcore.ci;

public class Person {
	private String name;
	private int id;
	private Certificate crt;
	
	public Person(String name, int id, Certificate crt) {
		super();
		this.name = name;
		this.id = id;
		this.crt = crt;
	}

	@Override
	public String toString() {
		return this.name+": " + this.id + " {" + this.crt.name + "}";
	}	
}
