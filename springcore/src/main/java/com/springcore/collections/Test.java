package com.springcore.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/collections/collectionConfig.xml");
		
		Student student = (Student) context.getBean("student1");
		System.out.println(student);
	}

}
