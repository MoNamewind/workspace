package com.bj58.mail.send;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.Test;



public class Test1 {
	
	
	public static void main(String[] args) throws Exception {
		
		Message message=new MimeMessage(Session.getDefaultInstance(new Properties()));
		//必须先创建Content
		message.setContent("Today is fine day","text/html;charset=ISO8859-1");
		Object content1 = message.getContent();
		System.out.println(content1.toString());
		DataHandler handler = message.getDataHandler();
		
		Object content2=handler.getContent();
		System.out.println(content1==content2);
		
	}
	
	@Test
	public void test1() throws Exception{
		MimeMessage message=new MimeMessage(Session.getDefaultInstance(new Properties()));
		MimeMultipart mp=null;
		BodyPart part=null;
		mp.addBodyPart(part, 1);
		mp.getBodyPart(1);
	}
}
