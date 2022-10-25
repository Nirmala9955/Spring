package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JobSeekerInfo {
	private String jsName;
	private String jsAddress;
	private MultipartFile resume;
	private MultipartFile photo;
}
