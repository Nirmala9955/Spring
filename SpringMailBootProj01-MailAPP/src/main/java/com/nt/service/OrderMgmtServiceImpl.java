package com.nt.service;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderMgmtServiceImpl implements IOrderMgmtService {

	@Autowired
	private JavaMailSender sender;

	@Override
	public String purchase(String[] items, float[] prices, String customerEmail, String[] cc, String[] bcc) {
		// Calculate bill amount
		float bAmt = 0.0f;
		for (float p : prices)
			bAmt += p;
		String body = Arrays.toString(items) + "are purchased having price " + Arrays.toString(prices)
				+ " will bill amount " + bAmt + "rs. having order id " + new Random().nextInt(10000);
		boolean status = triggerMail(body, customerEmail, cc, bcc);
		return body + " mailed delivered: " + status;
	}

	private boolean triggerMail(String body, String customerEmail, String[] cc, String[] bcc) {
		boolean status=false;
		try { 
			//create MimeMessage object having using sender object
			MimeMessage msg = sender.createMimeMessage();
			//create MimeMessageHelper class object to make attachment process easy
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			//set content email message
			helper.setSubject("open to know it");
			helper.setTo(customerEmail);
			helper.setCc(cc);
			helper.setBcc(bcc);
			helper.setSentDate(new Date());
			helper.setText(body);
			helper.addAttachment("926926.jpg", new ClassPathResource("926926.jpg"));
			sender.send(msg);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			status=false;
		}
		return status;
		
	}

}
