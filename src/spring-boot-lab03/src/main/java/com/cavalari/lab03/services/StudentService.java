package com.cavalari.lab03.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.cavalari.lab03.model.Student;

@Service
public class StudentService {
	
	private Map<Long, Student> students;
	
	@PostConstruct
	public void init() {
		Student joao = new Student("João", 1234856, "joao@gmail.com");
		joao.setIdent(1L);
		
		Student maria = new Student("maria", 3453784, "maria@gmail.com");
		maria.setIdent(2L);
		
		Student tiago = new Student("tiago", 5675867, "tiago@gmail.com");
		tiago.setIdent(3L);
		
		Student caio = new Student("caio", 78978978, "caio@gmail.com");
		caio.setIdent(4L);
		
		students = new HashMap<>();
		students.put(1L, joao);
		students.put(2L, maria);
		students.put(3L, tiago);
		students.put(4L, caio);
	}

	public Student getStudent(Long id) {
		return students.get(id);
	}

	public Collection<Student> getStudents() {
		return students.values().stream().collect(Collectors.toList());
	}

	public Student addStudent(Student student) {
		student.setIdent(Long.valueOf(students.size() + 1));
		students.put(student.getIdent(), student);
		return student;
	}

	public Student updateStudent(Student student) {
		students.put(student.getIdent(), student);
		return student;
	}

	public Student deleteStudent(Long id) {
		Student student= students.get(id);
		students.remove(id);
		return student;
	}
	
	

}
