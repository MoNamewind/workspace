package com.bj58.testUtil.Mokito;

import org.junit.Before;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;


public class dd1 {
	
	public MockHttpServletRequest request;
	public MockHttpServletResponse response;
	public  MockHttpSession session;
	
	@Before
	public void before(){
		request=new MockHttpServletRequest();
		response=new MockHttpServletResponse();
		session=new MockHttpSession();
		request.setCharacterEncoding("UTF-8");
	}

}
