package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("fileService")
public class FileMgmtServiceImpl implements IFileMgmtService {

	@Override
	public List<String> fetchAllFiles(String uploadStore) {
		File file = null, content[]=null;
		List<String> fileNameList = null;
		//Create File object representing uploadStore folder
		file = new File(uploadStore);
		//get all Files and sub folders of uploadStore folder
		content = file.listFiles();
		fileNameList = new ArrayList<>();
		for (File f : content) {
			if (f.isFile()) 
				fileNameList.add(f.getName());
		}
		return fileNameList;
	}
	
}
