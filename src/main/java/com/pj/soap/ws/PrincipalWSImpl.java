package com.pj.soap.ws;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.pj.soap.ws.model.User;

@WebService(endpointInterface="com.pj.soap.ws.PrincipalWS")
public class PrincipalWSImpl implements PrincipalWS {

	@Resource
	private WebServiceContext webServiceContext;
	
	public String info() {
		
		MessageContext messageContext = webServiceContext.getMessageContext();
		
		Map httpHeaders = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		
		if(httpHeaders == null) {
			throwException("Header não informado!");
		}
		
		if( httpHeaders.get("username") == null ||  httpHeaders.get("password") == null) {
			throwException("Header inválido");
		}
		
		List<String> usernameList = (List<String>) httpHeaders.get("username");
		List<String> passwordList = (List<String>) httpHeaders.get("password");
		
		String username = usernameList.get(0);
		String password = passwordList.get(0);
		
		if((username == null || password == null) || (!"user".equals(username) || !"pass".equals(password))) {
			throwException("Acesso inválido!");
		}
		
		return "Principal with JAX-WS called successfully";
	}

	private void throwException(String message) {
		throw new RuntimeException(message);
	}

	public String query(String name, String surname, Integer age) {
		
		if(name == null || surname == null || age == null) {
			throwException("Dados inválidos para a consulta ao usuário!");
		}
		
		return "Full name: " + name + " " + surname + ", Age: " + age;
	}

}
