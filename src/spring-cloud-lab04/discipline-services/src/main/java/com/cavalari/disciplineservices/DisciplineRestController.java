package com.cavalari.disciplineservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplines")
public class DisciplineRestController {

	@Autowired
	private DisciplineRepository repository;

	@Autowired
	private StudentAPI studentAPI;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Discipline> getAll() {
		System.out.println("#######Respondendo consulta de disciplinas#######");
		return repository.findAll();
	}
	
	@GetMapping(path="/enrolledstudents", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Discipline> getAllEnrolledStudents() {
		List<Student> students = studentAPI.getAllStudent();
		List<Discipline> disciplines = repository.findAll();

		for (Discipline discipline : disciplines) {
			discipline.setStudentsEnrolled(students);
		}

		return disciplines;
	}

}
