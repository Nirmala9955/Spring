package com.nt.bo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public abstract class BaseBean {
	private int id;
	private String name;
	private LocalDateTime doj;
}
