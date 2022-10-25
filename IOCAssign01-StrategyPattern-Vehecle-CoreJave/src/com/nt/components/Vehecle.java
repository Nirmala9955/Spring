package com.nt.components;

public class Vehecle {
	
	//properties
	private Engine engine;
	private Tyre tyre;
	
	public Vehecle() {
		System.out.println("Vehecle : Vehecle()");
	}
	public void setEngine(Engine engine) {
		System.out.println("Vehecle : setEngine()");
		this.engine = engine;
	}
	public void setTyre(Tyre tyre) {
		System.out.println("Vehecle : setTyre()");
		this.tyre = tyre;
	}
	
	public String getInfromation() {
		return engine.usedIn()+"\n"+tyre.roadGrip();
	}
}
