package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;

@Component("empValidator")
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//useful to check correct command/ model class is received
		return clazz.isAssignableFrom(Employee.class); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate()");
		Employee emp = null;
		//Type casting on command class object
		emp = (Employee) target;
		//write form validation logic 
		if (emp.getEname()==null||emp.getEname().isEmpty()) {
			errors.rejectValue("ename", "emp.name.required");
		} else if (emp.getEname().length()<5||emp.getEname().length()>10) {
			errors.rejectValue("ename", "emp.name.length");
		}
		
		if (emp.getJob()==null||emp.getJob().isEmpty()) {
			errors.rejectValue("job", "emp.job.required");
		} else if (emp.getJob().length()<5||emp.getJob().length()>9) {
			errors.rejectValue("job", "emp.job.length");
		} 
		
		if (emp.getSal()==null) {
			errors.rejectValue("sal", "emp.sal.required");
		} else if (emp.getSal()<10000||emp.getSal()>100000) {
			errors.rejectValue("sal", "emp.sal.range");
		} 		
	}

}
