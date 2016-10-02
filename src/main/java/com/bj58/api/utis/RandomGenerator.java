package com.bj58.api.utis;

import java.util.Random;

import org.junit.Test;

public class RandomGenerator {

	
	public static String  range="0123456789abcdefghijklmnopqrstuvwxyz";
	public static String getRandomString() {
		Random random=new Random();
		StringBuffer buffer=new StringBuffer();
		for (int i = 0; i < 8; i++) {
			buffer.append(range.charAt(random.nextInt(range.length())));
			
		}
		
		return buffer.toString();
	}
	
	@Test
	public void test(){
		System.out.println(getRandomString());
	}

}
