package com.nt.aspect;

import java.io.FileWriter;

import org.aspectj.lang.JoinPoint;

public class DiscountCouponAspect {
	
	/*public void coupon(JoinPoint jp, float billAmount) throws Throwable {
		String couponMsg=null;	
		//generate Coupon message
		if (billAmount<10000)
			couponMsg="Available 5% discount on the next purchase";
		else if (billAmount<20000)
			couponMsg="Available 10% discount on the next purchase";
		else if (billAmount<30000)
			couponMsg="Available 15% discount on the next purchase";
		else
			couponMsg="Available 20% discount on the next purchase";
		//Generate cupon
		FileWriter writer = new FileWriter("coupon.txt");
		writer.write(couponMsg);
		writer.flush();
		writer.close();
	
	}*/

	public void coupon(float billAmount) throws Throwable {
		String couponMsg=null;	
		//generate Coupon message
		if (billAmount<10000)
			couponMsg="Available 5% discount on the next purchase";
		else if (billAmount<20000)
			couponMsg="Available 10% discount on the next purchase";
		else if (billAmount<30000)
			couponMsg="Available 15% discount on the next purchase";
		else
			couponMsg="Available 20% discount on the next purchase";
		//Generate cupon
		FileWriter writer = new FileWriter("coupon.txt");
		writer.write(couponMsg);
		writer.flush();
		writer.close();
		
	}
	
}
