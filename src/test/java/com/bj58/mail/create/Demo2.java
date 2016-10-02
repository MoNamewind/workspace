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



//基于MIME协议创建复杂邮件(文本+图片)
public class Demo2 {
	public static void main(String[] args) throws Exception {
		
		//创建一封邮件
		MimeMessage message = new MimeMessage(Session.getDefaultInstance(new Properties()));
		
		//设置From属性
		message.setFrom(new InternetAddress("aaa@zhaojun.com"));
		
		//设置To属性
		message.setRecipient(RecipientType.TO,new InternetAddress("bbb@qq.com"));
		
		//设置Subject属性
		message.setSubject("text+image");
		
		//文本
		MimeBodyPart text = new MimeBodyPart();
		text.setContent("this is a <br/><img src='cid:imageID'/><br/>picture<br/>","text/html;charset=ISO8859-1");
		
		//图片
		MimeBodyPart image = new MimeBodyPart();
		//读取cc.JPG图片
		DataHandler dh = new DataHandler(new FileDataSource("src/test/Java/com/bj58/mail/config/cc.jpg"));
		//设置MimeBodyPart和DataHandler的关联
		image.setDataHandler(dh);
		//为图片设置一个唯一编号
		image.setContentID("imageID");
		
		//设置文本和图片的关系
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(text);
		mm.addBodyPart(image);
		mm.setSubType("related");
		
		//设置整个邮件的关系
		message.setContent(mm);
		
		//将该邮件保存的硬盘
		message.writeTo(new FileOutputStream("d:\\demo2.eml"));
		
	}
}


