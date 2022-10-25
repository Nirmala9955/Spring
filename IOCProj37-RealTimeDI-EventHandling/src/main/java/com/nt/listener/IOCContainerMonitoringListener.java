package com.nt.listener;

import java.util.Date;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class IOCContainerMonitoringListener implements ApplicationListener {
	
	private long start, end;
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event.toString().indexOf("ContextRefreshedEvent")!=-1) {
			start = System.currentTimeMillis();
			System.out.println("IoC container is started at : "+new Date());
		} 
		else if (event.toString().indexOf("ContextClosedEvent")!=1) {
			end = System.currentTimeMillis();
			System.out.println("IoC container is stoped at : "+new Date());
			System.out.println("IoC Container active duration is : "+(end-start));
		}
	}

}
