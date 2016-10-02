package com.bj58.mail.create;


import java.io.FileOutputStream;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//基于MIME协议创建复杂邮件(1文本+1图片+1附件)
public class Demo4 {
	
	public static void main(String[] args) throws Exception {
		
		//创建一封邮件
		MimeMessage message = new MimeMessage(Session.getDefaultInstance(new Properties()));
		
		//设置From属性
		message.setFrom(new InternetAddress("aaa@zhaojun.com"));
		
		//设置To属性
		message.setRecipient(RecipientType.TO,new InternetAddress("bbb@qq.com"));
		
		//设置Subject属性
		message.setSubject("text+image+append");
		
		//文本
		MimeBodyPart text = new MimeBodyPart();
		text.setContent("this is a<br/><img src='cid:imageID'/><br/>image<br/>","text/html;charset=ISO8859-1");
		
		//图片
		MimeBodyPart image = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("src/cn/itcast/web/mail/config/cc.jpg"));
		image.setDataHandler(dh);
		image.setContentID("imageID");
		
		//附件
		MimeBodyPart append = new MimeBodyPart();
		dh = new DataHandler(new FileDataSource("src/cn/itcast/web/mail/config/abc.txt"));
		append.setDataHandler(dh);
		append.setFileName(dh.getName());
		
		//文本+图片
		MimeMultipart mm1 = new MimeMultipart();
		mm1.addBodyPart(text);
		mm1.addBodyPart(image);
		mm1.setSubType("related");

		//将文本+图片封装成邮件的组成部分，即将关系看作成一个部分
		MimeBodyPart temp = new MimeBodyPart();
		temp.setContent(mm1);
		
		//设置和附件的关系
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(temp);
		mm.addBodyPart(append);
		mm.setSubType("mixed");
		
		//设置整个邮件的关系
		message.setContent(mm);
		
		//将该邮件保存的硬盘
		message.writeTo(new FileOutputStream("d:\\demo4.eml"));
		
	}
}




