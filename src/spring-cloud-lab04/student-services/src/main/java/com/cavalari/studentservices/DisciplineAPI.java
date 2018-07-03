package com.cavalari.studentservices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("discipline-services")
public interface DisciplineAPI {
	@RequestMapping(value = "/disciplines", method = RequestMethod.GET)
	List<Discipline> getAllDisciplines();
	
	@RequestMapping(value = "/disciplines/{id}", method = RequestMethod.GET)
	Discipline getDiscipline(@PathVariable("id") Long id);
}
