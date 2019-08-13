package com.pj.soap.ws.main;

import com.pj.soap.ws.publisher.PrincipalPublisher;

public class PrincipalMain {

	public static void main(String[] args) {
		
		PrincipalPublisher principalPublisher = new PrincipalPublisher();
		principalPublisher.toPublish();
	}
}
