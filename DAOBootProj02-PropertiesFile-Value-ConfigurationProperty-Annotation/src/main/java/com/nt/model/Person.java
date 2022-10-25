package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("per")
@ConfigurationProperties(prefix = "per.info")
public class Person {
	private int id;
	private String name;
	private String address;
	private int[] marks1;
	private List<Integer> marks2;
	private Set<Integer> marks3;
	private Map<String, Integer> phones;
	private Job job; //HAS-A relation property
}
