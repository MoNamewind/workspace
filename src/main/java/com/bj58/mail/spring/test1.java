package com.bj58.mail.spring;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class test1 {

	public static void sendFileMail() throws MessagingException {  
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  
  
        // 设定mail server  
        senderImpl.setHost("smtp.126.com");  
        senderImpl.setUsername("liusj1991");  
        senderImpl.setPassword("89190505?abc"); 

        // 建立HTML邮件消息  
        MimeMessage mailMessage = senderImpl.createMimeMessage();  
        // true表示开始附件模式  
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");  
  
        // 设置收件人，寄件人  
        messageHelper.setTo("1324226933@qq.com");  
        messageHelper.setFrom("liusj1991@126.com");  
        messageHelper.setSubject("测试邮件！");  
        // true 表示启动HTML格式的邮件  
        messageHelper.setText("<html><head></head><body><h1>你好：附件！！</h1></body></html>", true);  
  
        FileSystemResource file1 = new FileSystemResource(new File("d:/logo.jpg"));  
        FileSystemResource file2 = new FileSystemResource(new File("d:/读书.txt"));  
        // 添加2个附件  
        messageHelper.addAttachment("logo.jpg", file1);  
          
        try {  
            //附件名有中文可能出现乱码  
            messageHelper.addAttachment(MimeUtility.encodeWord("读书.txt"), file2);  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            throw new MessagingException();  
        }  
        // 发送邮件  
        senderImpl.send(mailMessage);  
        System.out.println("邮件发送成功.....");  
  
    }  
	public static void main(String[] args) throws MessagingException {
		sendFileMail();
	}

}
