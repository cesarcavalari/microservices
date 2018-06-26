package com.cavalari.lab06;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class StudentResourceAssembler extends ResourceAssemblerSupport<Student, StudentResource> {
	
	public StudentResourceAssembler() {
		super(Student.class, StudentResource.class);
	}

	@Override
	public StudentResource toResource(Student student) {
		return new StudentResource(student, linkTo(methodOn(StudentRestController.class).get(student.getId())).withSelfRel());
	}
	
	@Override
	protected StudentResource instantiateResource(Student student) {
		return new StudentResource(student);
	}

}