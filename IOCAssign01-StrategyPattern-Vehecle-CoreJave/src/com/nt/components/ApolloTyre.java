package com.nt.components;

public class ApolloTyre implements Tyre {

	public ApolloTyre() {
		System.out.println("ApolloTyre : ApolloTyre()");
	}
	
	@Override
	public String roadGrip() {
		return "Apollo Tyre : Standard Road Grip - Suitable for Transportation";
	}

}
