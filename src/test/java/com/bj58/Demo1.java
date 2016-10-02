package com.bj58;

import sun.misc.BASE64Encoder;

public class Demo1 {
	
	
	public static void main(String[] args) {
		
		String name="john";
		String password="89190505?abc";
		BASE64Encoder encoder=new BASE64Encoder();
		name=encoder.encode(name.getBytes());
		password=encoder.encode(password.getBytes());
		System.out.println(name);
		System.out.println(password);
		
	}

}
