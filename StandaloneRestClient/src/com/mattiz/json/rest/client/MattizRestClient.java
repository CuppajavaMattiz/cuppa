package com.mattiz.json.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.http.client.ClientProtocolException;

public class MattizRestClient {

	public static void main(String args[]) throws Exception {
		new MattizRestClient().getResponseData();
	}

	public JSONObject getResponseData() throws Exception {
		JSONObject reqObj = new JSONObject();
		JSONObject responseObj = null;
		try {
			String baseUrl = "http://localhost:8080/RestServiceExampleWithJson/restservices/";
			String contextPath = "mattiz/";
			String requestBody = reqObj.toString();
			System.out.println("requestBody--->>" + requestBody);
			String contextParam = null;
			String requestType = "GET";
			InputStream is = new JsonRestful().processRequest(baseUrl,
					contextPath, requestBody, contextParam, requestType);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer sb = new StringBuffer();
			while ((line = br.readLine()) != null) {
				System.out.println("Response raw string :" + line);
				// Prints out JSON response string
				sb.append(line);
			}
			// Parse response string
			responseObj = (JSONObject) JSONSerializer.toJSON(sb.toString());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new RuntimeException("MattizException");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException("MattizException");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("MattizException");
		}
		return responseObj;
	}

}
