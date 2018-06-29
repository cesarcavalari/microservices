package com.cavalari.eurekaclient;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
@RequestMapping("/students")
public class StudentRestController {
	
	@Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;
    @Value("${service.disciplines.serviceId}")
    private String disciplinesServiceId;

	@Autowired
	StudentRepository repository;
	
	@PostConstruct
	public void init() {
		repository.save(new Student(1l, "Cesar", 11111, "cesar@gmail.com", new Date()));
		repository.save(new Student(2l, "Miguel", 22222, "miguel@gmail.com", new Date()));
		repository.save(new Student(3l, "Gabriel", 33333, "gabriel.@gmail.com", new Date()));
		repository.save(new Student(4l, "Dani", 44444,"dani@gmail.com", new Date()));
		repository.save(new Student(5l, "Moni", 55555,"moni@gmail.com", new Date()));		
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Student> getAll() {
		return repository.findAll();
	}
	
	
	@GetMapping(path="/disciplines" ,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Discipline> getDisciplines() {
		Application application = eurekaClient.getApplication(disciplinesServiceId);
	    InstanceInfo instanceInfo = application.getInstances().get(0);
	    String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "disciplines";
	    
	    ResponseEntity<List<Discipline>> reponse = restTemplate.exchange(
				url, 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Discipline>>() {});
	    
	    return reponse.getBody();
	}
	
}
