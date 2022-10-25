package com.nt.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("container")
public abstract class WebContainer {
	
	public WebContainer() {
		System.out.println("WebContainer : WebContainer()");
	}
	
	@Lookup
	public abstract RequestHandler createRequestHandler();
	
	public void processRequest(String data) {
		System.out.println("WebContainer is processing request with data : "+data+" by giving it to handler.");
		RequestHandler handler = null;
		//get Dependent object using dependency lookup code generatedby the container
		handler = createRequestHandler();
		handler.handleRequest(data);
	}	
	
}
