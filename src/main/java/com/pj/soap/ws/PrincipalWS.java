package com.pj.soap.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.RequestWrapper;

@WebService
@SOAPBinding(style=Style.RPC)
public interface PrincipalWS {

	@WebMethod
	String info();
	
	@WebMethod
	@RequestWrapper(localName="user", className="com.pj.soap.ws.model.User")
	String query(@WebParam(name="name") String name, @WebParam(name="surname") String surname, @WebParam(name="age") Integer age);
}
