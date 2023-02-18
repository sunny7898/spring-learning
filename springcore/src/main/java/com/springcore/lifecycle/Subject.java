package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Subject {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject() {
		super();
	}
	
	@PostConstruct
	public void imitiateInit() {
		System.out.println("Inside init of annotation");
	}

	@PreDestroy
	public void imitateDestroy(){
		System.out.println("Inside destroy of annotation");
	}
}
