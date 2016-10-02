package com.bj58.baiduyun.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件的批量上传
 * @author liushujin
 *
 */
public class UploadUtil {
	
	/**
	 * 批量上传的工具类
	 * @param request
	 * @param response
	 * @return 
	 * nijap</br>
	 * <a href="www.ke.qq.com">nihao</a>
	 */
	public static HashMap<String , Object> uploadFiles(HttpServletRequest request,HttpServletResponse response) {
		
		HashMap<String , Object> map=new HashMap<String , Object>();
		try {
			//设置编码集
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String realPath=request.getRealPath("/");
			
		} catch (UnsupportedEncodingException e) {
			
		}
		return map;
	}
	
	
	public static void main(String[] args) {

		System.out.println("大家好，^_^");
		//1.编写
	}

}
