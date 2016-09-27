package com.bj58.aawebmvc;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class dd {
	
	private String phonestring;
	private String phonestring1;
	@Before
	public void init(){
		phonestring="^((13[0-9])|(15[^4,\\D])|(18[0,5-9])";
		phonestring1="^[1][3-8]+\\d{9}$";
	}
	@Test
	public void validatePhoneNumber(){
		assertTrue("niaho", "18601297084".matches(phonestring1));
		//assertTrue("18601297084".matches(phonestring1));
		//assertTrue("11111111111".matches(phonestring1));
		
		assertEquals(true, "18601297084".matches(phonestring1));
		assertEquals(false,"11111111111".matches(phonestring1));
	}

}
