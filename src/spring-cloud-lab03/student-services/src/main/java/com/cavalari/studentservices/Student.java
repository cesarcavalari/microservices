package com.cavalari.studentservices;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String name;
	Integer registration;
	String email;
	Date dateOfBirth;
	@Transient
	List<Discipline> disciplines; 
		
}