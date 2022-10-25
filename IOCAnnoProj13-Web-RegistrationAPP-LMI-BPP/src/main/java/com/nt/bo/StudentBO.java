package com.nt.bo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("stuBO")
@Scope("prototype")
public class StudentBO extends BaseBean {
	private String sadd;
	private String course;
	private int total;
	private float avg;
}
