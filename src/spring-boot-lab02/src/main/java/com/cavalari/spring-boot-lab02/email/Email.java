package com.voffice.properties.email;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Email {

	private static final Logger LOGGER = LoggerFactory.getLogger(Email.class);

	@Value("${email.from}")
	private String from;
	@Value("${email.subject}")
	private String to;
	@Value("${email.to}")
	private String subject;

	@Autowired
	private Environment enviroment;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSmtp() {
		return enviroment.getProperty("email.smtp");
	}

	@PostConstruct
	public void init() {
		LOGGER.info("##########################################################");
		LOGGER.info("########### FROM: " + getFrom() + " ######################");
		LOGGER.info("########### TO: " + getTo() + " ##########################");
		LOGGER.info("########### SUBJECT: " + getSubject() + " ################");
		LOGGER.info("########### SMTP: " + getSmtp() + " ######################");
		LOGGER.info("##########################################################");
	}

}
