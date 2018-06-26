package com.cavalari.lab06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("cesar").password("$2a$04$5IBezkMo9VhrU/pNI8cnR.taDZrpjNmPm01roFtAfqzC8A.0LiYH2").roles("USER")
			.and().withUser("maria").password("$2a$04$5IBezkMo9VhrU/pNI8cnR.taDZrpjNmPm01roFtAfqzC8A.0LiYH2").roles("USER", "MANAGER")
			.and().withUser("fred").password("$2a$04$5IBezkMo9VhrU/pNI8cnR.taDZrpjNmPm01roFtAfqzC8A.0LiYH2").roles("USER", "MANAGER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/swagger-ui.html", "/swagger-resources/**").permitAll()
			.antMatchers("/students/**").hasAnyRole("USER")
			.antMatchers("/disciplines/**").hasAnyRole("MANAGER")
			.anyRequest().fullyAuthenticated()
			.and().httpBasic().and().csrf().disable();
	}
}