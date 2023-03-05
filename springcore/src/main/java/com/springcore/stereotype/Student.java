package com.springcore.stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("student")
@Scope("prototype")
public class Student {
	@Value("Sunny Goswami")
	private String name;
	@Value("Hyderabad")
	private String city;
	@Value("#{address}")
	private List<String> addresses;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public List<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", city=" + city + ", addresses=" + addresses + "]";
	}
	
}