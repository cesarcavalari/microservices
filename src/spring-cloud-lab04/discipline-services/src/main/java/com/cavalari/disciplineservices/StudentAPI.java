package com.cavalari.disciplineservices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("student-services-ribbon")
public interface StudentAPI {
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	List<Student> getAllStudent();
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	Student getStudent(@PathVariable("id") Long id);
}