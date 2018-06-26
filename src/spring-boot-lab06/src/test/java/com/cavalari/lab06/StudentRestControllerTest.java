package com.cavalari.lab06;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cavalari.lab06.Student;
import com.cavalari.lab06.StudentRestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentRestController.class)
public class StudentRestControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper jsonParser;
	
	@Test
	public void shouldGetAll() throws Exception {
		mockMvc.perform(get("/students"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.[0].id", equalTo(1)))
				.andExpect(jsonPath("$.[0].name", equalTo("Cesar")))
				.andExpect(jsonPath("$.[1].id", equalTo(2)))
				.andExpect(jsonPath("$.[1].name", equalTo("Miguel")));
	}
	
	@Test
	public void shouldGetById() throws Exception {
		mockMvc.perform(get("/students/{id}", 1))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id", equalTo(1)))
				.andExpect(jsonPath("$.name", equalTo("Cesar")));
	}

	@Test
	public void testCreate() throws Exception {
		Student aluno = new Student(6l, "Barbara", 89741, "barbara@gmail.com", new Date());
		mockMvc.perform(post("/students").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(jsonParser.writeValueAsString(aluno)))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id", equalTo(6)))
				.andExpect(jsonPath("$.name", equalTo("Barbara")));
	}
	
}
