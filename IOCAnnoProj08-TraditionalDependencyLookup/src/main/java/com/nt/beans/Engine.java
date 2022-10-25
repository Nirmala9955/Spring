package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("engg")
public class Engine {
	
	public Engine() {
		System.out.println("Engine : Engine()");
	}
	
	public void start() {
		System.out.println("Engine : start() - Engine Started");
	}
	
	public void stop() {
		System.out.println("Engine : stop() - Engine Stopped");
	}
	
}
