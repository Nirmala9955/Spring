package com.nt.bo;

public class CustomerBO {
	
	//all bean property 
	private String cname;
	private String cadd;
	private float pAmnt;
	private float interAmt;
	
	//setters and getters
	public String getCname() {
		return cname;
	}
	
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public String getCadd() {
		return cadd;
	}
	
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	
	public float getpAmnt() {
		return pAmnt;
	}
	
	public void setpAmnt(float pAmnt) {
		this.pAmnt = pAmnt;
	}
	
	public float getInterAmt() {
		return interAmt;
	}
	
	public void setInterAmt(float interAmt) {
		this.interAmt = interAmt;
	}
	
}
