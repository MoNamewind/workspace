package com.bj58.api.services.imp;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.bj58.api.services.IAccountCaptchaService;

public class AccountCaptchaServiceImpTest {
	
	private IAccountCaptchaService service;
	
	@Before
	public void Init(){
		ApplicationContext context=new ClassPathXmlApplicationContext("account-captcha.xml");
		service=(IAccountCaptchaService) context.getBean("accountCaptchaService");
	}
	

	@Test
	public void testGenerateCaptchaKey() throws Exception {
		String captchaKey=service.generateCaptchaKey();
		assertNotNull(captchaKey);
		byte[] captchaImage = service.generateCaptchaImage(captchaKey);
		System.out.println(captchaImage.length);
		assertTrue(captchaImage.length>0);
		File image=new File("target/"+captchaKey+".jpg");
		OutputStream out;
		try {
			out=new FileOutputStream(image);
			try {
				out.write(captchaImage);
				out.flush();//写道本地文件
			}finally {
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(image.exists()&&image.length()>0);
	}

	@Test
	public void testGenerateCaptchaImage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPreDefinedTexts() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPreDefinedTexts() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidateCaptcha() {
		fail("Not yet implemented");
	}
	
	public void test(){
		
		
	}
	

}
