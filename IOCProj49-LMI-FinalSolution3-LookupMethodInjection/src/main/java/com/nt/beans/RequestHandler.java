package com.nt.beans;

public class RequestHandler {
	
	private static int count;
	
	public RequestHandler() {
		count++;
		System.out.println("RquestHandler : RquestHandler() : "+count);
	}
	
	public void handleRequest(String data) {
		System.out.println("Handling request with "+data+" using the object "+count);
	}
	
}
