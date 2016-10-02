package com.bj58.spider.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.bj58.spider.utils.SpiderUtils;

public class GetImage {
	
	public static void main(String[] args) {
		//第一步获取前台传过来的参数（ 妹子类型，翻页的参数）
		
		//String pageNUm
		
		
	}
	public void main(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//第一步获取前台传过来的参数（ 妹子类型，翻页的参数）
		
		String pageNum=request.getParameter("pageNum");
		String category=request.getParameter("category");
		List<Image> images=SpiderUtils.queryImageList(category, pageNum);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(JSONArray.toJSONString(images,true));
		out.flush();
		out.close();
		
	}
	

}
