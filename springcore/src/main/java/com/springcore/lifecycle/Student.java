package com.springcore.lifecycle;

public class Student {
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		System.out.println("Setting id");
		this.id = id;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
	public void init() {
		System.out.println("Inside init method!");
	}
	
	public void destroy() {
		System.out.println("Inside destroy method!");
	}
}
