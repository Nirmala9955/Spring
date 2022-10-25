package com.nt.dao;

import java.util.List;

import com.nt.bo.CoronaPatientBO;

public interface CoronaPatientDAO {
	public List<CoronaPatientBO> getCoronaPatientsByDist(String dist) throws Exception;
}
