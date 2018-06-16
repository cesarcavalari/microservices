package com.voffice.restfulapp.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

@XmlRootElement
public class Student extends ResourceSupport {

	private Long ident;
	private String nome;
	private Integer matricula;
	private String email;
	
	public Student(String nome, Integer matricula, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
	}
	
	public Student() {
		// default
	}

	public Long getIdent() {
		return this.ident;
	}

	public void setIdent(Long id) {
		this.ident = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
