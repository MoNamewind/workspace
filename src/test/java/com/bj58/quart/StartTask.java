package com.bj58.quart;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartTask {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-quart.xml");
		System.out.println(context.getBean("jobDetail"));
		
	}
	@Test
	public void test() throws Exception{
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-quart2.xml");
		context.getBean("SpringJobSchedulerFactoryBean");
		Thread.sleep(10000);
	}

}
