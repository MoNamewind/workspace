package com.bj58.mail.spring;

import static org.junit.Assert.*;

import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bj58.api.services.IAcountEmailService;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

public class Test2 {
	private GreenMail greenMail;
	
	@Before
	public void startMailServer(){
		greenMail=new GreenMail(ServerSetup.SMTP);
		greenMail.setUser("test@juvenxu.com", "123456");
		greenMail.start();
	}
	@Test
	public  void testSendMail() throws Exception{
		ApplicationContext context=new ClassPathXmlApplicationContext("account-email.xml");
		IAcountEmailService service =(IAcountEmailService) context.getBean("accountEmailService");
		String subject="Test subject";
		String htmlText="<h3>Test</h3>";
		service.sendEmail("test@juvenxu.com", subject, htmlText);
		MimeMessage[] messages = greenMail.getReceivedMessages();
		assertEquals(1,messages.length);
		assertEquals(subject, messages[0].getSubject());
		assertEquals(htmlText, GreenMailUtil.getBody(messages[0]).trim());
		
	}
	@After
	public void stopEmailServer(){
		greenMail.stop();
	}
	

}

