package com.bj58.api.controllers;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bj58.api.utis.JVMMermeryUtil;

/**
 * 查询Java虚拟机相关的信息
 * @description
 * @author liushujin01
 * @since  2016年9月17日
 */
@Controller
public class JVMController {
	
	@RequestMapping("/JvmUI.action")
	public String getMER1() throws Exception{
		return "jvm";
	}
	
	@RequestMapping("/JvmInfo.action")
	public void getMER(HttpServletResponse response) throws Exception{
		String info=JVMMermeryUtil.getJVMInfo();
		response.setContentType("text/html;charset=UTF-8");
		Writer out=response.getWriter();
		out.write(info);
		out.flush();
		out.close();
	}

}
