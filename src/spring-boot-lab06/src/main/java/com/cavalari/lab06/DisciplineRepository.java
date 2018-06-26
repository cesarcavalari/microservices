package com.cavalari.lab06;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

	@RestResource(path = "/aftercurrent")
	@Query("select d from Discipline d where d.startDate > CURRENT_DATE")
	List<Discipline> findByStartDateAfterCurrent();
	
}