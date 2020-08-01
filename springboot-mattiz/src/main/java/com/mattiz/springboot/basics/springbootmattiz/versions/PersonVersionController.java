package com.mattiz.springboot.basics.springbootmattiz.versions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

	@GetMapping("/Person/V1")
	public Person getPerson() {
		return new Person(new Name("Tom", "Thomas"));
	}
	
	@GetMapping("/Person/V2")
	public PersonV2 getPersonV2() {		
		return new PersonV2("Cuppa Java");
	}
	
	@GetMapping(value="/Person/param", params="version=1")
	public Person getPersonByParam() {
		return new Person(new Name("Tom", "Thomas"));
	}
	
	@GetMapping(value="/Person/param", params="version=2")
	public PersonV2 getPersonV2ByParam() {		
		return new PersonV2("Cuppa Java");
	}
	
	@GetMapping(value="/Person/header", headers="X-API-VER=1")
	public Person getPersonByHeader() {
		return new Person(new Name("Tom", "Thomas"));
	}
	
	@GetMapping(value="/Person/header", headers="X-API-VER=2")
	public PersonV2 getPersonV2ByHeader() {		
		return new PersonV2("Cuppa Java");
	}
	
	@GetMapping(value="/Person/producer", produces="application/mattiz.com.app.v1+json")
	public Person getPersonByProducer() {
		return new Person(new Name("Tom", "Thomas"));
	}
	
	@GetMapping(value="/Person/producer", produces="application/mattiz.com.app.v2+json")
	public PersonV2 getPersonV2ByProducer() {		
		return new PersonV2("Cuppa Java");
	}
}
