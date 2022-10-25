package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.entity.Project;

@Repository("projDAO")
public class ProjectDAOImpl implements ProjectDAO {
	
	private static final String HQL_GET_PROJECT_BY_COST_RANGE = "FROM com.nt.entity.Project WHERE cost>=:min AND cost<=:max";
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer insert(Project entity) {
		Integer idVal = null;
		// use HibernateTemplate
		idVal = (Integer) ht.save(entity);
		return idVal;
	}

	@Override
	public Project getProjectById(int id) {
		Project proj = null;
		//get Object
		proj = ht.get(Project.class, id);
		return proj;
	}

	@Override
	public boolean updateProjectById(int id, int teamSize, double cost) {
		Project proj = null;
		boolean flag = false;
		//get Object
		proj = ht.get(Project.class, id);
		if (proj!=null) {
			//update object
			proj.setTeamSize(teamSize);
			proj.setCost(cost);
			ht.update(proj);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteProjectById(int id) {
		Project proj = null;
		boolean flag = false;
		//get Object
		proj = ht.get(Project.class, id);
		if (proj!=null) {
			//delete object
			ht.delete(proj);
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Project> getProjectByCostRange(double start, double end) {
		List<Project> list = null;
		list = (List<Project>) ht.findByNamedParam(HQL_GET_PROJECT_BY_COST_RANGE, new String[] {"min", "max"}, new Object[] {start, end});
		return list; 
	}

}
