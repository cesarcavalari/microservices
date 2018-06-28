package com.cavalari.configclientlab01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/properties")
public class PropertyController {
	
	@Value("${app.config.property.service-name}")
	private String serviceName;
	
	@Value("${app.config.property.service-ip}")
	private String serviceIp;
	
	@GetMapping
	public Map<String, Object> getProperties() {
		Map<String, Object> props = new HashMap<>();
		props.put("app.config.property.service-name", serviceName);
		props.put("app.config.property.service-ip", serviceIp);
		return props;
	}

}
