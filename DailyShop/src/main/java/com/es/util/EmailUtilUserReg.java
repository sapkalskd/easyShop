package com.es.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmailUtilUserReg {

	@Autowired
	private JavaMailSender sender;
	
	/*
	 * Actual Logic
	 * @param to
	 * @param subject
	 * @param text
	 * @param cc
	 * @param bcc
	 * @param file
	 * @return
	 * 
	 * */
	
	public boolean sendEmail(
							String to,
							String subject, 
							String text, 
							String[]cc,
							String[] bcc,
							MultipartFile file) 
	{
		
		boolean sent = false;
		try {
			//create Mime-message object
			MimeMessage message = sender.createMimeMessage();
			
			//use Helper Class Object
			
			MimeMessageHelper helper = 
					new MimeMessageHelper(message,file != null ? true : false);
			
			//set details to object
			helper.setTo(to);
			
			helper.setSubject(subject);
			
			helper.setText(text);
			
			if(cc != null && cc.length > 0)
				helper.setCc(cc);
			
			if(bcc != null && bcc.length > 0)
				helper.setBcc(bcc);
			
			if(file != null)
				helper.addAttachment(file.getOriginalFilename(), file);
			
			//send email
			sender.send(message);
			
			sent = true;
		}
		catch (Exception e) {
			sent = false;
			e.printStackTrace();
		}
		
		return sent;
	}
		
}
