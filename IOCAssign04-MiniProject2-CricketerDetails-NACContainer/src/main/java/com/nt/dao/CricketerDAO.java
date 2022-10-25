package com.nt.dao;

import java.util.List;

import com.nt.bo.CricketerBO;

public interface CricketerDAO {
	public List<CricketerBO> getCricketersByRole(String role) throws Exception;
}
