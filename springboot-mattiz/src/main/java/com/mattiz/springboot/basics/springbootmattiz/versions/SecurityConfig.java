package com.mattiz.springboot.basics.springbootmattiz.versions;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

	@Configuration
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
	    }
	}
