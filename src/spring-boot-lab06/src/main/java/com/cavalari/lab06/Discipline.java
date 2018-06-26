package com.cavalari.lab06;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
}
