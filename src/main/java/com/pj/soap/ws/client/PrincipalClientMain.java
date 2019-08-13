package com.pj.soap.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import com.pj.soap.ws.PrincipalWS;

public class PrincipalClientMain {

	private static final String URL_WS_WSDL = "http://localhost:8000/ws/principalWS?wsdl";

	public static void main(String[] args) {
		
		try {
			URL url = new URL(URL_WS_WSDL);
		
			QName qName = new QName("http://ws.soap.pj.com/", "PrincipalWSImplService");
			
			Service service = Service.create(url, qName);
		
			PrincipalWS principalWS = service.getPort(PrincipalWS.class);
			
			String stringResult = principalWS.query("Fulano", "de Tal", 36);
			
			System.out.println("Result >>> : " + stringResult);
			
			Map<String, List<String>> headers = new HashMap<String, List<String>>();
			headers.put("username", Collections.singletonList("user"));
			headers.put("password", Collections.singletonList("pass"));
			
			BindingProvider bindingProviderPrincipalWS = (BindingProvider) principalWS;
			
			Map<String, Object> requestContext = bindingProviderPrincipalWS.getRequestContext();
			requestContext.put(bindingProviderPrincipalWS.ENDPOINT_ADDRESS_PROPERTY, URL_WS_WSDL);

			requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
			
			System.out.println(" Message Info: " + principalWS.info());
			
		} catch (MalformedURLException e) {
			System.out.println("Falha ao tentar criar URL de acesso ao WS!");
		} catch(Exception e) {
			System.out.println("Erro interno ao tentar consumir WS! \n Message: " + e.getMessage());
		}
	}
	
	
	
}
