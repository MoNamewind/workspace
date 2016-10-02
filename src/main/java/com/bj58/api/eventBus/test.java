package com.bj58.api.eventBus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	
	
	public static void main(String[] args) {
		ApplicationContext aContext=new ClassPathXmlApplicationContext("spring-eventbus.xml");
		TimeEventBus.post(new TimeExpiringEvent());
	}

}
