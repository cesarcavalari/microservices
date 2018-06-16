package com.cavalari.lab03.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.cavalari.lab03.controller.StudentController;
import com.cavalari.lab03.model.Student;

@Component
public class StudentResourceAssembler extends ResourceAssemblerSupport<Student, StudentResource> {
	
	public StudentResourceAssembler() {
		super(Student.class, StudentResource.class);
	}

	@Override
	public StudentResource toResource(Student student) {
		return new StudentResource(student, 
				linkTo(methodOn(StudentController.class).getStudent(student.getIdent())).withSelfRel());
	}
	
	@Override
	protected StudentResource instantiateResource(Student student) {
		return new StudentResource(student);
	}

}
