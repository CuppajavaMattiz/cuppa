package com.mattiz.springboot.basics.springbootmattiz;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MattizBean retreiveMattizBean() {
		return new MattizBean("val1", "val2", "val3");
	}
	
	@GetMapping("/filtering/list")
	public List<MattizBean> retreiveMattizBeanList() {
		return Arrays.asList(new MattizBean("val1", "val2", "val3"),new MattizBean("val1", "val2", "val3"));
	}
	
	@GetMapping("/filtering/dynamic")
	public MappingJacksonValue retreiveMattizBeanListDynamic() {
		List arr = Arrays.asList(new MattizBeanTwo("val1", "val2", "val3"),new MattizBeanTwo("val1", "val2", "val3"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName");
		FilterProvider filters = new SimpleFilterProvider().addFilter("MattizBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(arr);
		mapping.setFilters(filters);
		return mapping;
	}
}
