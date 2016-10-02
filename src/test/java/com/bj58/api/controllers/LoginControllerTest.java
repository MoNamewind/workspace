package com.bj58.api.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import com.bj58.api.domain.User;

@SpringApplicationContext({"classpath:account-captcha.xml","file:webapp/WEB-INF/action-servlet.xml"})
public class LoginControllerTest extends UnitilsJUnit4{
    
	@SpringBeanByType
	private AnnotationMethodHandlerAdapter handlerAdapter;
	
	@SpringBeanByType
	private LoginController controller;
	
	public MockHttpServletRequest request;
	public MockHttpServletResponse response;
	
	@Before
	public void before(){
		request=new MockHttpServletRequest();
		response=new MockHttpServletResponse();
		request.setCharacterEncoding("UTF-8");
	}
	
	@Test
	public void loginCheck() throws Exception {
		request.setRequestURI("/loginCheck.action");
		request.addParameter("userName", "tom");
		request.addParameter("password", "1234");
		ModelAndView mav=handlerAdapter.handle(request, response, controller);
		User user=(User) request.getSession().getAttribute("user");
		assertNotNull(user);
		assertEquals(mav.getViewName(), "main");
		assertNotNull(user);
		//assertThat(user.getUserName(), equalsTo("tom"));
		//assertThat(user.getCredits(), greaterThan(5));
		
	}

}
