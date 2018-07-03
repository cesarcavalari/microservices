package com.cavalari.disciplineservices;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discipline {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String name;
	Integer workload;
	Date startDate;
	@Transient
	List<Student> studentsEnrolled; 
	
}
