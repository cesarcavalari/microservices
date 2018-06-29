package com.cavalari.disciplineservices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@RepositoryRestResource
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

//	@RestResource(path = "/aftercurrent")
	@Query("select d from Discipline d where d.startDate > CURRENT_DATE")
	List<Discipline> findByStartDateAfterCurrent();
	
}