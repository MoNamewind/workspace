package com.bj58.mail.basic.Useage;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//基于JavaMail发送[简单]邮件
public class Demo1 {
	public static void main(String[] args) throws Exception {
		//设置发送邮件的环境信息，例如协议和主机
		Properties props = new Properties();
		props.put("mail.transport.protocol","smtp");
		//props.put("mail.host","127.0.0.1");
		props.put("mail.host","smtp.126.com");
		props.put("mail.debug","true");
		//props.put("mail.port","123434");
		//props.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props);
		//取得传输对象
		Transport transport = session.getTransport();
		//创建邮件
		Message message = createMessage(session);
		//连接邮件服务器
		//transport.connect();
		try {
			transport.connect("liusj1991@126.com","89190505?abc");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//发送邮件
		//transport.send(message);//该方法发送失败
		transport.sendMessage(message, InternetAddress.parse("1324226933@qq.com"));
		
		System.out.println("邮件发送成功。。。");
		
		//关闭传输对象
		transport.close();
	}
	//创建简单邮件
	public static Message createMessage(Session session) throws Exception{
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("liusj1991@126.com"));
		message.setRecipient(RecipientType.TO,new InternetAddress("1324226933@qq.com"));
		message.setSubject("BBS论坛");
		message.setContent("<font color='red'>恭喜你，注册成功</font>","text/html;charset=UTF-8");
		return message;
	} 
}