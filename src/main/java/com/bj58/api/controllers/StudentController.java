package com.bj58.api.controllers;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bj58.api.Dao.Student;
import com.bj58.api.services.IExportExcelService;

@Controller
public class StudentController {
	@Autowired
	private IExportExcelService exportExcel;
	/**
	 * 用excel导出学生的信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/exportExcel.action")
	public void exportStudentInfoByExcel(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("octets/stream");
		String excelFileName="Student学生信息表";
		try {
			//解决文件名乱码问题
			String fileName=new String(excelFileName.getBytes("UTF-8"),"ISO-8859-1");
			response.addHeader("Content-Disposition", "attachment;filename="+fileName+".xls");
			List<Student> students = exportExcel.queryStudentList();
			OutputStream out=response.getOutputStream();
			String[] headers=new String[]{"id","姓名","年龄","电话"};
			exportExcel.exportExcel(excelFileName, headers, students, out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
