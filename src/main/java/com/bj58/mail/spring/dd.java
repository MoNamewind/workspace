package com.bj58.mail.spring;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bj58.api.services.IAcountEmailService;

public class dd implements IAcountEmailService {

	private JavaMailSender sender=new JavaMailSenderImpl();
	private String systemMail; 
	@Override
	public void sendEmail(String to, String subject, String htmlText) throws Exception {
		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		helper.setFrom(systemMail);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(htmlText, true);
		sender.send(message);
	}

}
