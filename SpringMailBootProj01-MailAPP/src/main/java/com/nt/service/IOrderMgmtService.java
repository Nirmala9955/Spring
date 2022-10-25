package com.nt.service;

public interface IOrderMgmtService {
	public String purchase(String[] items, float[] prices, String customerEmail, String[] cc, String[]bcc);
}
