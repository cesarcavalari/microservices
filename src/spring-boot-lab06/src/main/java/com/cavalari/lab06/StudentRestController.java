package com.cavalari.lab06;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentRestController {

	@Autowired
	StudentRepository repository;
	
	StudentResourceAssembler assembler = new StudentResourceAssembler();
	
	@PostConstruct
	public void init() {
		repository.save(new Student(1l, "Cesar", 11111, "cesar@gmail.com", new Date()));
		repository.save(new Student(2l, "Miguel", 22222, "miguel@gmail.com", new Date()));
		repository.save(new Student(3l, "Gabriel", 33333, "gabriel.@gmail.com", new Date()));
		repository.save(new Student(4l, "Dani", 44444,"dani@gmail.com", new Date()));
		repository.save(new Student(5l, "Moni", 55555,"moni@gmail.com", new Date()));		
	}
	
	@Secured("ROLE_USER")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<StudentResource>> getAll() {
		return new ResponseEntity<>(assembler.toResources(repository.findAll()), HttpStatus.OK);
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/{id}")
	public ResponseEntity<StudentResource> get(@PathVariable Long id) {
		Optional<Student> student = repository.findById(id);
		if (student.isPresent()) {			
			return new ResponseEntity<>(assembler.toResource(student.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@Secured("ROLE_MANAGER")
	@PostMapping
	public ResponseEntity<StudentResource> create(@RequestBody Student student) {
		student = repository.save(student);
		if (student != null) {
			return new ResponseEntity<>(assembler.toResource(student), HttpStatus.OK);					
		} else {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@Secured("ROLE_MANAGER")
	@PutMapping("/{id}")
	public ResponseEntity<StudentResource> update(@PathVariable Long id, @RequestBody Student student) {
		if (student != null) {
			student.setId(id);
			student = repository.save(student);
			return new ResponseEntity<>(assembler.toResource(student), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@Secured("ROLE_MANAGER")
	@DeleteMapping("/{id}")
	public ResponseEntity<StudentResource> delete(@PathVariable Long id) {
		Optional<Student> student = repository.findById(id);
		if (student.isPresent()) {
			repository.delete(student.get());
			return new ResponseEntity<>(assembler.toResource(student.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/name/{name}")
	public ResponseEntity<List<StudentResource>> findByNome(@PathVariable String name) {
		return new ResponseEntity<>(assembler.toResources(repository.findByNameContaining(name)), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/dateofbirth/month/current")
	public ResponseEntity<List<StudentResource>> findByDateOfBirthAtCurrentMonth() {
		int mesCorrente = Calendar.getInstance().get(Calendar.MONTH) + 1;
		return new ResponseEntity<>(
				assembler.toResources(repository.findByDateOfBirthAtCurrentMonth(mesCorrente)), 
				HttpStatus.OK);
	}
}
