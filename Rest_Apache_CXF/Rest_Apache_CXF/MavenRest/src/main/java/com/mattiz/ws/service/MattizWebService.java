package com.mattiz.ws.service;

import java.rmi.Remote;


import javax.jws.WebService;

@WebService(targetNamespace = "http:/com.mattiz/wsdl")
public interface MattizWebService extends Remote {
	public String getWelcomeString();
}
