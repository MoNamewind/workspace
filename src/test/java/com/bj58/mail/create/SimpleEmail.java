package com.bj58.mail.create;

import java.io.FileOutputStream;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//基于MIME协议创建简单邮件
public class SimpleEmail {
	public static void main(String[] args) throws Exception {
		//创建一封邮件
		MimeMessage message = new MimeMessage(Session.getDefaultInstance(new Properties()));
		//设置From属性
		message.setFrom(new InternetAddress("aaa@zhaojun.com"));
		//设置To属性
		message.setRecipient(RecipientType.TO,new InternetAddress("bbb@qq.com"));
		//设置Subject属性
		message.setSubject("test");
		//设置Content属性
		message.setContent("Today is fine day","text/html;charset=ISO8859-1");
		//将该邮件保存的硬盘
		message.writeTo(new FileOutputStream("d:\\demo1.eml"));
	}
}