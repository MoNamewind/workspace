package com.bj58.mail.send;


import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class Demo2 {
	
	public static void main(String[] args) throws Exception {
		
		Properties props = new Properties();
		// 开启debug调试
		props.setProperty("mail.debug", "true");
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		// 设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.qq.com");
		props.setProperty("mail.port", "25");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);
		
		Session session = Session.getInstance(props);
		 
		//邮件内容部分
		Message msg = new MimeMessage(session);
		msg.setSubject("seenews 错误");
		StringBuilder builder = new StringBuilder();
		builder.append("url = " + "http://blog.csdn.net/never_cxb/article/details/50524571");
		builder.append("页面爬虫错误");
		builder.append("\n data " + System.currentTimeMillis());
		msg.setText(builder.toString());
		//邮件发送者
		msg.setFrom(new InternetAddress("1324226933@qq.com"));
		 
		//发送邮件
		Transport transport = session.getTransport();
		transport.connect("smtp.qq.com", "1324226933@qq.com", "89190505?abc");
		 
		transport.sendMessage(msg, new Address[] { new InternetAddress("liusj1991@126.com") });
		transport.close();
		
	}

}
