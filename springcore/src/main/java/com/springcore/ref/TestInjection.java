package com.springcore.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInjection {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ref/refconfig.xml");
		
		A aobj = (A) context.getBean("aref");
		System.out.println(aobj.getX());
		System.out.println(aobj.getObj().getY());
		System.out.println(aobj);
	}

}
