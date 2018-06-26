package com.cavalari.lab05;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path="/disciplinas")
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

	@RestResource(path = "/aftercurrentdate")
	@Query("select d from Disciplina d where d.dataInicio > CURRENT_DATE")
	List<Disciplina> findByDataInicioAfterCurrent();
	
}