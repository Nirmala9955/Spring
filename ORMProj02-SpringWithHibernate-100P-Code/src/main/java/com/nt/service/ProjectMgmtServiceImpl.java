package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.ProjectDAO;
import com.nt.dto.ProjectDTO;
import com.nt.entity.Project;

@Service("projService")
@Transactional(transactionManager = "hbTxMgmr")
public class ProjectMgmtServiceImpl implements ProjectMgmtService {
	
	@Autowired
	private ProjectDAO dao; 
	
	@Override
	public String registerProject(ProjectDTO dto) {
		Project entity = null;
		Integer  idVal = null;
		//Convert DTO to BO/entity
		entity = new Project();
		BeanUtils.copyProperties(dto, entity);
		//use DAO
		idVal = dao.insert(entity);
		
		return "Project is Registered with the Project ID : "+idVal;
	}

	@Override
	public Object fetchProjectById(int id) {
		Project proj = null;
		ProjectDTO dto = null;
		//use DAO 
		proj = dao.getProjectById(id);
		//convert entity to dto
		if (proj!=null) {	
			dto = new ProjectDTO();
			BeanUtils.copyProperties(proj, dto);
		}
		return dto!=null?dto:"Record not found";
	}

	@Override
	public String modifyProjectById(int id, int teamSize, double cost) {
		boolean flag = false;
		//use DAO
		flag = dao.updateProjectById(id, teamSize, cost);
		return flag==false?"Record not found for update":"Record updated";
	}

	@Override
	public String removeProjectById(int id) {
		boolean flag = false;
		//use DAO
		flag = dao.deleteProjectById(id);
		return flag==false?"Record not found for delete":"Record deleted";
	}

	@Override
	public List<ProjectDTO> fetchProjectByCostRange(double start, double end) {
		List<Project> listEntities = null;
		List<ProjectDTO> listDTO = new ArrayList();
		//use dao
		listEntities = dao.getProjectByCostRange(start, end);
		//covert listEntities to listDTO
		listEntities.forEach(entity -> {
			ProjectDTO dto = new ProjectDTO();
			BeanUtils.copyProperties(entity, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

}
