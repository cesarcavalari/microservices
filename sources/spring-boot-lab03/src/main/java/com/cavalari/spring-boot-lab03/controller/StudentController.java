package com.voffice.restfulapp.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.voffice.restfulapp.model.Student;
import com.voffice.restfulapp.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
//	@RequestMapping(path = "{id}",
//			method = RequestMethod.GET,
//			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Student st = service.getStudent(id);
		st.add(linkTo(methodOn(StudentController.class).getStudent(1L)).withSelfRel());
	    return new ResponseEntity<>(st, HttpStatus.OK);
	}
	
	@GetMapping
	public Collection<Student> getStudents() {
		return service.getStudents();
	}
	
	@PostMapping
	public void addStudent(@RequestBody Student student) {
		service.addStudent(student);
	}
	
	@PutMapping
	public void updateStudent(@RequestBody Student student) {
		service.updateStudent(student);
	}
	
	@DeleteMapping("{id}")
	public void deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
	}

}
