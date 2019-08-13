package com.pj.soap.ws.publisher;

import javax.xml.ws.Endpoint;

import com.pj.soap.ws.PrincipalWSImpl;

public class PrincipalPublisher {

	public void toPublish() {
		
		Endpoint.publish("http://localhost:8000/ws/principalWS", implementor());
		
		System.out.println("To Access this WS call to the URL >>> http://localhost:8000/ws/principalWS?wsdl");
	}

	private PrincipalWSImpl implementor() {
		return new PrincipalWSImpl();
	}
}
