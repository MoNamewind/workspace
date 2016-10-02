package com.bj58.api.controllers;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.bj58.spider.controllers.Image;
import com.bj58.spider.utils.SpiderUtils;

@Controller
public class GeneralController {

	@RequestMapping("/index.action")
	public void index_jsp(Model model){
		model.addAttribute("username", "黎明你好");
		System.out.println("index.jsp");
	}
	
	@RequestMapping("/spider.action")
	public String spider(Model model){
		 return "spider/doubanMeizi";
	}
	@RequestMapping("/getImage.action")
	public void getImage(String category,String pageNum,HttpServletResponse response) throws Exception{
		System.out.println(category+"  "+pageNum);
		List<Image> images = SpiderUtils.queryImageList(category, pageNum);
		System.out.println(images.size());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(JSONArray.toJSONString(images,true));
		out.close();
	}
}

