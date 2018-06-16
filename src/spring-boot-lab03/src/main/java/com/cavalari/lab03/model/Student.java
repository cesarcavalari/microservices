package com.cavalari.lab03.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

@XmlRootElement
public class Student extends ResourceSupport {

	private Long ident;
	private String name;
	private Integer registration;
	private String email;

	public Student(String name, Integer registration, String email) {
		this.name = name;
		this.registration = registration;
		this.email = email;
	}

	public Student() {
		// default
	}

	public Long getIdent() {
		return ident;
	}

	public void setIdent(Long ident) {
		this.ident = ident;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRegistration() {
		return registration;
	}

	public void setRegistration(Integer registration) {
		this.registration = registration;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
