package com.mattiz.rest.service;

import org.springframework.stereotype.Service;

@Service("mattizService")
public class MattizServiceImpl implements MattizService {
	public String getWelcomeString() {
		return ("Hallo Mattiz World!");
	}
}