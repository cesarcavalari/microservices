package com.cavalari.lab03.resource;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import com.cavalari.lab03.model.Student;

@XmlRootElement
@XmlSeeAlso({Student.class})
public class StudentResource extends Resource<Student>{

	public StudentResource() {
		this(new Student());
	}
	
	public StudentResource(Student student, Link... links) {
		super(student, links);
	}
}
