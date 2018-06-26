package com.cavalari.lab06;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	StudentRepository repository;
	
	@Test
	public void shouldSaveStudent() throws Exception {
		Student aluno = Student.builder()
				.name("Patricia").registration(147852)
				.email("patricia@gmail.com").dateOfBirth(new Date()).build();
		
		aluno = repository.save(aluno);
		
		assertNotNull(aluno);
		assertTrue(aluno.getId() != null);
	}
	
	@Test
	public void shouldDeleteStudent() throws Exception {
		Student aluno = entityManager.persist(Student.builder()
				.name("Miguel").registration(22222)
				.email("miguel@gmail.com")
				.dateOfBirth(new Date()).build());
		
		repository.delete(aluno);		
		Optional<Student> alunoOpt = repository.findById(aluno.getId());
		
		assertFalse(alunoOpt.isPresent());
	}
	
	@Test
	public void shouldFindByNome() throws Exception {
		entityManager.persistAndFlush(Student.builder()
				.name("Pablo").registration(852963)
				.email("Pablo@gmail.com")
				.dateOfBirth(new Date()).build());
		
		List<Student> students = repository.findByNameContaining("Pablo");
		
		assertNotNull(students);
		assertFalse(students.isEmpty());
		assertTrue(students.get(0).getName().equals("Pablo"));
	}
	
	
	

}
