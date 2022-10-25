package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOIndexedException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.JobSeekerInfo;
import com.nt.service.IFileMgmtService;

@Controller
public class JobSeekerController {
	
	@Autowired
	private ServletContext sc;
	
	@Autowired
	private IFileMgmtService service;
	
	@GetMapping("/upload")
	public String showUploadForm(@ModelAttribute("jsFrm") JobSeekerInfo info) {
		return "jobseeker_form";
	}

	@PostMapping("/upload")
	public String uploadFiles(Map<String, Object> map, @ModelAttribute("jsFrm") JobSeekerInfo info) throws Exception {
		String folderLocation = null, resumeName=null, photoName=null;
		File file = null;
		InputStream resumeIS = null, photoIS = null;
		OutputStream resumeOS = null, photoOS = null;
		//Get upload folder location from web.xml file context param
		folderLocation = sc.getInitParameter("UploadStore");
		//Check weather that folder is available or not, if not create a new folder
		file = new File(folderLocation);
		//Check store folder availability 
		if (!file.exists())
			//if not there create store folder
			file.mkdirs();
		
		//get Uploaded file names
		resumeName = info.getResume().getOriginalFilename();
		photoName = info.getPhoto().getOriginalFilename();
		
		//Check condition for Resume
		File resumeFile = new File(resumeName);
		if (resumeFile.length()>10*1024*1024) 
			throw new IllegalStateException();
		if (resumeName.endsWith("pdf")||resumeName.endsWith("src")) 
			throw new IllegalStateException(); 
			
			
		//create InputStream pointing uploaded file context
		resumeIS = info.getResume().getInputStream();
		photoIS = info.getPhoto().getInputStream();
		//Create OutputStream pointing to empty destination files
		resumeOS = new FileOutputStream(folderLocation+"/"+resumeName);
		photoOS = new FileOutputStream(folderLocation+"/"+photoName);
		//copy uploaded context to destination
		IOUtils.copy(resumeIS, resumeOS);
		IOUtils.copy(photoIS, photoOS);
		//Keeps the name of the uploaded files as model attributes
		map.put("resumeFileName", resumeName);
		map.put("photoFileName", photoName);
		
		//close streams
		resumeIS.close();
		resumeOS.close();
		photoIS.close();
		photoOS.close();
		return "upload_success";
	}
	
	@GetMapping("list_files")
	public String showAllFiles(Map<String, Object> map) {
		String uploadStore = null;
		List<String> fileNameList = null;
		//get uploadStore Folder name form web.xml file as context param value
		uploadStore = sc.getInitParameter("UploadStore");
		//use service
		fileNameList = service.fetchAllFiles(uploadStore);
		//keep results in model attribute 
		map.put("filesList", fileNameList);
		//return LVN
		return "show_file";
	}
	
	@GetMapping("/download")
	public String downloadFile(@RequestParam("fname") String fileName, HttpServletResponse res) throws Exception {
		File file = null;
		String filePath = null, mimeType=null;
		InputStream is = null;
		OutputStream os = null;
		//get Path of the Downloadable file 
		filePath = sc.getInitParameter("UploadStore")+"/"+fileName;
		//Create file object pointing to the file to be download
		file = new File(filePath);
		//set file length as response content length
		res.setContentLengthLong(file.length());
		//get MIMEt type of the file 
		mimeType = sc.getMimeType(filePath);
		res.setContentType(mimeType==null?"application/octet-stream":mimeType);
		//create inputStream pointing to the file to be downloaded
		is = new FileInputStream(filePath);
		//create output Stream pointing response object
		os = res.getOutputStream();
		//Give instruction to browser to make there received content as download
		res.setHeader("content-disposition","attachement;filename="+fileName);
		//copy file content to response object
		IOUtils.copy(is, os);
		//take LVN is null
		return null;
	}

}
