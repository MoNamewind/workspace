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

//基于MIME协议创建复杂邮件(文本+附件)
public class Demo3 {
	public static void main(String[] args) throws Exception {
		
		//创建一封邮件
		MimeMessage message = new MimeMessage(Session.getDefaultInstance(new Properties()));
		
		//设置From属性
		message.setFrom(new InternetAddress("aaa@zhaojun.com"));
		
		//设置To属性
		message.setRecipient(RecipientType.TO,new InternetAddress("bbb@qq.com"));
		
		//设置Subject属性
		message.setSubject("text+append");
		
		//文本
		MimeBodyPart text = new MimeBodyPart();
		text.setContent("this is a append<br/>","text/html;charset=ISO8859-1");
		
		//附件1
		MimeBodyPart append1 = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("src/cn/itcast/web/mail/config/apache-tomcat-7.0.12.zip"));
		append1.setDataHandler(dh);
		//设置附件的名字
		append1.setFileName(dh.getName());

		/*附件2
		MimeBodyPart append2 = new MimeBodyPart();
		dh = new DataHandler(new FileDataSource("src/cn/itcast/web/mail/config/apache-tomcat-6.0.29.zip"));
		append2.setDataHandler(dh);
		//设置附件的名字
		append2.setFileName(dh.getName());
		*/
		
		//设置文本和附件的关系
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(text);
		mm.addBodyPart(append1);
		//mm.addBodyPart(append2);
		mm.setSubType("mixed");

		//设置整个邮件的关系
		message.setContent(mm);
		
		//将该邮件保存的硬盘
		message.writeTo(new FileOutputStream("d:\\demo3.eml"));
		
	}
}





