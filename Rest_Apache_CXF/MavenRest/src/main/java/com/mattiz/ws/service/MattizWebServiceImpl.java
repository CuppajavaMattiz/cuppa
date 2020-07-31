package com.mattiz.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattiz.rest.service.MattizService;

@Service("mattizWebService")
@WebService(serviceName = "/MattizWebService", portName = "MattizWebServicePort", targetNamespace = "http:/com.mattiz/wsdl", endpointInterface = "com.mattiz.ws.service.MattizWebService")
public class MattizWebServiceImpl implements MattizWebService {

	@Autowired
	private MattizService mattizService;

	@WebMethod(operationName = "getWelcomeString", action = "urn:getWelcomeString")
	public String getWelcomeString() {
		String welcomeString = null;
		try {
			welcomeString = mattizService.getWelcomeString();
			return welcomeString;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public MattizService getMattizService() {
		return mattizService;
	}

	public void setMattizService(MattizService mattizService) {
		this.mattizService = mattizService;
	}
	
}
