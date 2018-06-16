package com.voffice.restfulapp.services;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.voffice.restfulapp.controller.StudentController;
import com.voffice.restfulapp.model.Student;

@Service
public class StudentService {
	
	private Map<Long, Student> students;

	public StudentService() {
		Student st = new Student("fulano", 123456, "fulano@gmail.com");
		st.setIdent(1L);
		students = new HashMap<>();
		students.put(1L, st);
	}

	public Student getStudent(Long id) {
		return students.get(id);
	}

	public Collection<Student> getStudents() {
		Collection<Student> std = new ArrayList<>();
		students.forEach((id, student)->{
			student.add(linkTo(methodOn(StudentController.class).getStudent(student.getIdent())).withSelfRel());
			std.add(student);
		});
		return std;
	}

	public void addStudent(Student student) {
		students.put(Long.valueOf(students.size() + 1), student);
	}

	public void updateStudent(Student student) {
		students.put(student.getIdent(), student);		
	}

	public void deleteStudent(Long id) {
		students.remove(id);
	}
	
	

}
