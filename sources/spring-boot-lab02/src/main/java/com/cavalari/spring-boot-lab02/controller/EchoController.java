package com.voffice.properties.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

	@GetMapping("/echo")
	public String echo() {
		return "ECHO PROPERTIES";
	}
}
