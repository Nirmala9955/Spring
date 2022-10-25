package com.nt.dto;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nt.bo.BaseBean;

import lombok.Data;

@Data
@Component("stuDTO")
@Scope("prototype")
public class StudentDTO extends BaseBean implements Serializable {
	private String sadd;
	private String course;
	private int m1, m2, m3;
}
