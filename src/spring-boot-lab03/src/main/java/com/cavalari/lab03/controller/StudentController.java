package com.cavalari.lab03.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.cavalari.lab03.model.Student;
import com.cavalari.lab03.resource.StudentResource;
import com.cavalari.lab03.resource.StudentResourceAssembler;
import com.cavalari.lab03.services.StudentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private StudentResourceAssembler assembler;
	
	@ApiOperation("Returns a student")
	@GetMapping("/{id}")
	public ResponseEntity<StudentResource> getStudent(@PathVariable Long id) {
		return new ResponseEntity<>(assembler.toResource(service.getStudent(id)), HttpStatus.OK);
	}
	
	@ApiOperation("Returns a list of student")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Collection<StudentResource>> getStudents() {
		return new ResponseEntity<>(assembler.toResources(service.getStudents()), HttpStatus.OK);
	}
	
	@ApiOperation("Creates a student")
	@PostMapping
	public ResponseEntity<StudentResource> addStudent(@RequestBody Student student) {
		return new ResponseEntity<>(assembler.toResource(service.addStudent(student)), HttpStatus.OK);
	}
	
	@ApiOperation("Update a student")
	@PutMapping
	public ResponseEntity<StudentResource> updateStudent(@RequestBody Student student) {
		return new ResponseEntity<>(assembler.toResource(service.updateStudent(student)), HttpStatus.OK);
	}
	
	@ApiOperation("Delete a student")
	@DeleteMapping("{id}")
	public void deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
	}

}
