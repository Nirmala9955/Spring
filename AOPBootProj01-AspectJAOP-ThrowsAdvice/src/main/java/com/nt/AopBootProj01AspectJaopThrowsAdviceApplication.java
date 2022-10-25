package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.service.ShoppingStore;

@SpringBootApplication
public class AopBootProj01AspectJaopThrowsAdviceApplication {

	public static void main(String[] args) {
		// get container
		ApplicationContext ctx = SpringApplication.run(AopBootProj01AspectJaopThrowsAdviceApplication.class, args);
		// get Proxy object
		ShoppingStore storeProxy = ctx.getBean("shopping", ShoppingStore.class);
		try {
			// invoke method
			System.out.println("Bill Aount: " + storeProxy.generateBill(new String[] { "shirt", "Trouser", "Belt" },
					new float[] { 5000, 3000, 0 }));
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// close container
		((AbstractApplicationContext) ctx).close();
	}

}
