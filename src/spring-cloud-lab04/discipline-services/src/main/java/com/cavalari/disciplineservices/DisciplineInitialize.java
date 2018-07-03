package com.cavalari.disciplineservices;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisciplineInitialize {
	
	@Autowired
	private DisciplineRepository repository;
	
	@PostConstruct
	public void init() {
		repository.save(new Discipline(1l, "Matematica", 10, new Date(), null));
		repository.save(new Discipline(2l, "Portugues", 15, new Date(), null));
		repository.save(new Discipline(3l, "História", 13, new Date(), null));
		repository.save(new Discipline(4l, "Quimica", 50, new Date(), null));
		repository.save(new Discipline(5l, "Artes", 40, new Date(), null));
	}

}
