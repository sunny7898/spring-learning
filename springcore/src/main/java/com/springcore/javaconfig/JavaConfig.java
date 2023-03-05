package com.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	@Bean
	public Address getAddressBean(){
		return new Address();
	}
	
	@Bean
	public Student getStudentBean(){
		return new Student(getAddressBean());
	}
}
