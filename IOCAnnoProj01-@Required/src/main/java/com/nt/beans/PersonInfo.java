package com.nt.beans;

import org.springframework.beans.factory.annotation.Required;

public class PersonInfo {
	
	private int pid;
	private String pname;
	private String paddress;
	
	@Required
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	@Required
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	@Override
	public String toString() {
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + "]";
	}

}
