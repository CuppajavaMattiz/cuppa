package com.mattiz.ws.client;

import com.mattiz.ws.test.bean.MattizWebService;
import com.mattiz.ws.test.bean._002fMattizWebService;

public class MattizWSClientTest {

	public static void main(String[] args) {
		try {
			MattizWebService port = new _002fMattizWebService().getMattizWebServicePort();
			System.out.println(port.getWelcomeString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}