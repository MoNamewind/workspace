package com.bj58.activeMq.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.bj58.api.domain.Mail;

@Service
public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SimpleMailMessage simpleMailMessage;
	@Autowired
	private ThreadPoolTaskExecutor threadPool;
	
	public void mailSend(final Mail mail){
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					simpleMailMessage.setFrom(mail.getFrom());
					simpleMailMessage.setTo(mail.getTo());
					simpleMailMessage.setSubject(mail.getSubject());
					simpleMailMessage.setText(mail.getContent());
					mailSender.send(simpleMailMessage);
				} catch (MailException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	

}
