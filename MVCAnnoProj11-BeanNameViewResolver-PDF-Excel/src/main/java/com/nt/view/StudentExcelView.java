package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.lowagie.text.Paragraph;
import com.nt.dto.StudentDTO;

@Component("excelView")
public class StudentExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<StudentDTO> listDTO = null;
		Paragraph para = null;
		// get model attribute data
		listDTO = (List<StudentDTO>) model.get("studentsInfo");
		Sheet sheet = workbook.createSheet("User List");

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("ID");
		header.createCell(1).setCellValue("Name");
		header.createCell(2).setCellValue("Address");
		header.createCell(3).setCellValue("Avreage");

		int rowNum = 1;

		for (StudentDTO dto : listDTO) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(dto.getSno());
			row.createCell(1).setCellValue(dto.getSname());
			row.createCell(2).setCellValue(dto.getAddress());
			row.createCell(3).setCellValue(dto.getAvg());
		}
	}

}
