package com.nt.dao;

import java.util.List;

import com.nt.entity.Project;

public interface ProjectDAO {
	//Single row operations
	public Integer insert(Project entity);
	public Project getProjectById(int id);
	public boolean updateProjectById(int id, int teamSize, double cost);
	public boolean deleteProjectById(int id);
	
	//bulk operations
	public List<Project> getProjectByCostRange(double start, double end);
}
