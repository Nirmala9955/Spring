package com.nt.editors;

import java.beans.PropertyEditorSupport;

import com.nt.beans.LoanAmountDetails;

public class LoanAmountDetailsEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		float pAmount=0.0f, rate=0.0f, time=0.0f;
		String info[] = null;
		LoanAmountDetails details = null;
		//split text into pAmount, rate, time
		/*pAmount = Float.parseFloat(text.substring(0, text.indexOf(",")));
		rate = Float.parseFloat(text.substring(text.indexOf(",")+1, text.lastIndexOf(",")));
		time = Float.parseFloat(text.substring(text.lastIndexOf(",")+1, text.length()));*/
		
		info = text.split(",");
		pAmount = Float.parseFloat(info[0]);
		rate = Float.parseFloat(info[1]);
		time = Float.parseFloat(info[2]);
		
		//create LoanAmountDetails object
		details = new LoanAmountDetails();
		details.setPAmount(pAmount);
		details.setRate(rate);
		details.setTime(time);
		//set details object to Bean Property as value
		setValue(details);
	}
	
}
