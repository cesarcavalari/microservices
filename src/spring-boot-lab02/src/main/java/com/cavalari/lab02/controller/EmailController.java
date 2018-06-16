package com.cavalari.lab02.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cavalari.lab02.model.Email;

@RestController
@RequestMapping("/email")
public class EmailController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	private Email email;
	
	@GetMapping("/from")
	public String getFrom() {
		LOGGER.info(email.getFrom());
		return email.getFrom();
	}
	
	@GetMapping("/to")
	public String getTo() {
		LOGGER.info(email.getTo());
		return email.getTo();
	}
	
	@GetMapping("/subject")
	public String getSubject() {
		LOGGER.info(email.getSubject());
		return email.getSubject();
	}
	
	@GetMapping("/smtp")
	public String getSmtp() {
		LOGGER.info(email.getSmtp());
		return email.getSmtp();
	}
	
}
