package com.mattiz.json.rest.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

public class JsonRestful {
	
	StatusLine statusLine = null;
	
	public InputStream processRequest(String baseUrl, String contextPath,
			String requestBody, String contextParam, String requestType)
			throws Exception {
		HttpResponse response = null;
		InputStream responseStream = null;
		try {
			HttpParams httpParameters = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParameters, 100000);
			HttpConnectionParams.setSoTimeout(httpParameters, 100000);
			HttpClient httpclient = new DefaultHttpClient(httpParameters);
			String url = makeUrl(baseUrl, contextPath, requestBody,
					contextParam);
			if (requestType.equals("GET")) {
				HttpGet httpGet = new HttpGet(url);
				httpGet.setHeader("Content-type", "application/json");
				response = httpclient.execute(httpGet);
			} else if (requestType.equals("POST")) {
				HttpPost httppost = new HttpPost(url);
				StringEntity params = new StringEntity(requestBody, HTTP.UTF_8);
				params.setContentType("application/json");
				httppost.setEntity(params);
				httppost.setHeader("Content-type", "application/json");
				response = httpclient.execute(httppost);
			}
			statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
				responseStream = response.getEntity().getContent();
			} else {
				throw new Exception("" + statusLine.getStatusCode());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new Exception("" + statusLine.getStatusCode());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new Exception("" + statusLine.getStatusCode());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new Exception("" + statusLine.getStatusCode());
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("" + statusLine.getStatusCode());
		}
		return responseStream;
	}

	private String makeUrl(String baseUrl, String contextPath,
			String requestBody, String contextParam)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(baseUrl);
		urlBuilder.append(contextPath);
		// urlBuilder.append(URLEncoder.encode(makeToken(requestBody)));
		// if MD5 auth is required
		System.out.println(":-) " + urlBuilder.toString());
		return urlBuilder.toString();
	}

	private String makeToken(String request) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		String str = request + "password";
		final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.reset();
		messageDigest.update(str.getBytes("UTF8"));
		final byte[] resultByte = messageDigest.digest();
		BigInteger bigInt = new BigInteger(1, resultByte);
		String hashtext = bigInt.toString(16);
		// We need to zero pad it if you actually want the full 32 chars.
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}
}
