package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Teacher implements InitializingBean, DisposableBean{
	private double marks;

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		System.out.println("Inside teacher block");
		this.marks = marks;
	}

	public Teacher() {
		super();
	}

	@Override
	public String toString() {
		return "Teacher [marks=" + marks + "]";
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside init (interface)");
	}

	public void destroy() throws Exception {
		System.out.println("Inside destroy (interface)");
	}
}
