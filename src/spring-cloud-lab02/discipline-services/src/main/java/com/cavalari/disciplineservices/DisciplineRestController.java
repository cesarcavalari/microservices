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
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Discipline> getAll() {
		System.out.println("#######Respondendo consulta de disciplinas#######");
		return repository.findAll();
	}
	
}
