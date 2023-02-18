package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/config.xml");
		
		Student s1 = (Student) context.getBean("student1");
		System.out.println(s1);
		context.registerShutdownHook();
	
		System.out.println("-----------------------------------------------------------");
		Teacher t1 = (Teacher) context.getBean("teacher1");
		System.out.println(t1);
		
		System.out.println("------------------------------------------------------------");
		Subject subject = (Subject) context.getBean("subject1");
		System.out.println(subject);
		
	}

}
