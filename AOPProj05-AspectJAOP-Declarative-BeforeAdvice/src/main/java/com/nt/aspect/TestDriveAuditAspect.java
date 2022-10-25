package com.nt.aspect;

import java.io.FileWriter;
import java.time.LocalDateTime;

public class TestDriveAuditAspect {
	
	/*public void testDrive(JoinPoint jp) throws Throwable {
		//get Target method args
		Object args[] = jp.getArgs();
		//write info to audit Log file
		FileWriter writer = new FileWriter("auditLog.txt", true);
		writer.write(args[0]+" model car test drive is taken under the monitoring of "+args[2]+" executive at "+LocalDateTime.now()+"\n");
		writer.flush();
		writer.close();
	}*/
	
	/*public void testDrive(JoinPoint jp, String model, float price, String executive) throws Throwable {
		//write info to audit Log file
		FileWriter writer = new FileWriter("auditLog.txt", true);
		writer.write(model+" model car test drive is taken under the monitoring of "+executive+" executive at "+LocalDateTime.now()+"\n");
		writer.flush();
		writer.close();
	}*/

	public void testDrive(String model, float price, String executive) throws Throwable {
		//write info to audit Log file
		FileWriter writer = new FileWriter("auditLog.txt", true);
		writer.write(model+" model car test drive is taken under the monitoring of "+executive+" executive at "+LocalDateTime.now()+"\n");
		writer.flush();
		writer.close();
	}
	
}
