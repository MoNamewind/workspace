package com.bj58.api.services;

import java.io.OutputStream;
import java.util.List;

import com.bj58.api.Dao.Student;

/**
 * @description 将数据库中文件导出为excel。
 * @author 58
 *
 */
public interface IExportExcelService {
	/**
	 * 
	 * @param title 标题
	 * @param headers 表头的描述字段
	 * @param students 学生信息列表
	 * @param out 输出流:将信息输出到out对应的流中。
	 * 
	 */
	public void exportExcel(String title,String[] headers,List<Student> students,OutputStream out);
	
	
	public  List<Student> queryStudentList() throws Exception;

}
