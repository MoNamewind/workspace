package com.bj58.api.utis;

import javax.servlet.http.HttpServletRequest;



public class SessionUtil {
	public static HttpServletRequest request1;
	public static void registerVo(HttpServletRequest request){
		request1=request;
	}
	public static void add(String name, Object o){
		request1.getSession().setAttribute(name, o);
	}
	public static Object get(String name){
		return request1.getSession().getAttribute(name);
	}
}
