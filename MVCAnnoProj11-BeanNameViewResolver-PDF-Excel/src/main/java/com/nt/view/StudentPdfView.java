package com.nt.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.dto.StudentDTO;

@Component("pdfView")
public class StudentPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<StudentDTO> listDTO = null;
		Paragraph para = null;
		// get model attribute data
		listDTO = (List<StudentDTO>) model.get("studentsInfo");
		//create and add paragraph
		para = new Paragraph("Student Details Report", new Font(Font.HELVETICA, 24, Font.BOLDITALIC, Color.CYAN));
		document.add(para);

		Table table = new Table(4);
		table.addCell("ID");
		table.addCell("Name");
		table.addCell("Address");
		table.addCell("Average");

		for (StudentDTO dto : listDTO) {
			table.addCell(String.valueOf(dto.getSno()));
			table.addCell(dto.getSname());
			table.addCell(dto.getAddress());
			table.addCell(String.valueOf(dto.getAvg()));
		}
		document.add(table);

	}

}
