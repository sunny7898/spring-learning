package com.springcore.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCI {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ci/ciconfig.xml");
		Person p = (Person) context.getBean("person");
		System.out.println(p);
		
	}
}
