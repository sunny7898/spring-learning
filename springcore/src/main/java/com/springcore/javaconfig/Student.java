package com.springcore.javaconfig;

import org.springframework.stereotype.Component;

public class Student {
	private Address address;

	public Student(Address address) {
		super();
		this.address = address;
	}
	
	public void printStudent() {
		this.address.printAddress();
		System.out.println("Student is here!");
	}
}
