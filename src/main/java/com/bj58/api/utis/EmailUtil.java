package com.bj58.api.utis;

import java.util.UUID;

public class EmailUtil {
	
	public final static String SUBJECT="用户注册";
	/**
	 * 
	 * @param to 接收邮件的地址；
	 * @param html 邮件的内容
	 */
	public static String getHtml(String url){
		String html="<html><head></head><body><h1>点击下面链接完成注册</h1><a herf="+url+">完成祖册</a></body></html>";
		return html;
	}
	public static String getUUid(){
		return UUID.randomUUID().toString();
	}
}
