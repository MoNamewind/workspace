package com.bj58.api.services.imp;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.security.auth.login.AccountException;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bj58.api.services.IAcountEmailService;

/**
 * 发送邮件的服务
 * @author 58
 *
 */
public class AccountEmailServiceImpl implements IAcountEmailService{
    Logger logger=Logger.getLogger(AccountEmailServiceImpl.class);
    private JavaMailSender javaMailSender;//spring提供的发送邮件的封装的类
	private String systemEmail;//发送方的邮件地址
	
	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public String getSystemEmail() {
		return systemEmail;
	}

	public void setSystemEmail(String systemEmail) {
		this.systemEmail = systemEmail;
	}
    /**
     * @param to 接收方的邮件地址；
     * @param subject 邮件的主题
     * @param htmlText 邮件的内容
     */
	@Override
	public void sendEmail(String to, String subject, String htmlText) throws Exception {
		logger.error("开始发送邮件。。。");
		try{
			MimeMessage msg=javaMailSender.createMimeMessage();
			// true表示开始附件模式  
	        MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "utf-8");  
			messageHelper.setFrom(systemEmail);
			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(htmlText,true);
			javaMailSender.send(msg);
		}catch (MessagingException e) {
			logger.error("发送失败",e);
			throw new AccountException("发送失败");
		}
		
	}

}
