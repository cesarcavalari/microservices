package com.cavalari.studentservices;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RibbonClient(name = "discipline-services", configuration = RibbonConfig.class)
public class StudentRestController {
	
	@Autowired
	private DisciplineAPI disciplineAPI;
	

	@Autowired
	StudentRepository repository;
	
	@PostConstruct
	public void init() {
		repository.save(new Student(1l, "Cesar", 11111, "cesar@gmail.com", new Date(), null));
		repository.save(new Student(2l, "Miguel", 22222, "miguel@gmail.com", new Date(), null));
		repository.save(new Student(3l, "Gabriel", 33333, "gabriel.@gmail.com", new Date(), null));
		repository.save(new Student(4l, "Dani", 44444,"dani@gmail.com", new Date(), null));
		repository.save(new Student(5l, "Moni", 55555,"moni@gmail.com", new Date(), null));		
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Student> getAll() {
		return repository.findAll();
	}

	@GetMapping(path="/disciplines" ,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Student> getWithDisciplines(){
		
		List<Discipline> disciplines = disciplineAPI.getAllDisciplines();
		
		List<Student> students = repository.findAll();
		for (Student student : students) {
			student.setDisciplines(disciplines);
		}
		return students;
	}
	
}
