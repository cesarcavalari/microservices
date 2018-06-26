package com.cavalari.lab06;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

public class StudentResource extends Resource<Student> {
	
	public StudentResource(Student student, Link... links) {
		super(student, links);
	}
	
}