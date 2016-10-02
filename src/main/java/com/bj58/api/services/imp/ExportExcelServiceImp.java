package com.bj58.api.services.imp;

import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bj58.api.Dao.Student;
import com.bj58.api.Dao.StudentDao;
import com.bj58.api.services.IExportExcelService;
/**
 * 
 * @description 导出到excel文件中。一个excel的工作薄有多个sheet页
 * 一个sheet页有多个row行，一个行有多个单元格（cell）
 * @author liushujin01
 * @since  2016年9月15日
 */
@Service
public class ExportExcelServiceImp implements IExportExcelService{
	
    @Autowired
	private StudentDao studentDao;
	@Override
	public void exportExcel(String title, String[] headers, List<Student> students, OutputStream out) {
		//创建一个excel的工作薄
		HSSFWorkbook workbook=new HSSFWorkbook();
		//创建一个sheet页
		HSSFSheet sheet=workbook.createSheet(title);
		
		sheet.setDefaultColumnWidth(20);//设置默认的列宽
		/*****************设置标题信息:option*****************/
		//创建标题行的单元格样式
		HSSFCellStyle titleStyle = workbook.createCellStyle();
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
		
		HSSFFont titleFont=workbook.createFont();//创建字体样式
		titleFont.setFontHeightInPoints((short)20);//字体大小
		
		titleStyle.setFont(titleFont);
		
		HSSFRow row = sheet.createRow(0);//创建第一行
		HSSFCell cell = row.createCell(0);//创建该行的第一个单元格
		//合并单元格(firstRow,lastRow,firstCol,lastCol)
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		cell.setCellValue("学生的基本信息");
		cell.setCellStyle(titleStyle);
		/**********************设置表头***************************/
		HSSFCellStyle headerStyle = workbook.createCellStyle();
		//设置前景颜色为轻橘黄色
		headerStyle.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
		headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		//设置边框
		headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);

		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		HSSFFont headerFont=workbook.createFont();
		headerFont.setColor(HSSFColor.BLUE.index);//设置为蓝色字体
		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headerFont.setFontHeightInPoints((short)14);
		
		headerStyle.setFont(titleFont);
		row=sheet.createRow(1);//创建第2行，来设置表头信息；
		for (int i = 0; i < headers.length; i++) {
			HSSFCell headerCell = row.createCell(i);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue(headers[i]);
			
		}
		/*****************设置内容*****************/
		HSSFCellStyle contentStyle = workbook.createCellStyle();
		//设置前景颜色为轻黄色
		contentStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		contentStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		//设置边框
		contentStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		contentStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		contentStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		contentStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);

		contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		contentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		HSSFFont contentFont=workbook.createFont();
		contentFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
	    for (int i = 0; i < students.size(); i++) {
	    	  row=sheet.createRow(i+2);
	    	  HSSFCell idCell = row.createCell(0);
	    	  idCell.setCellValue(students.get(i).getId());
	    	  idCell.setCellStyle(contentStyle);
	    	  
	    	  HSSFCell nameCell = row.createCell(1);
	    	  nameCell.setCellValue(students.get(i).getName());
	    	  nameCell.setCellStyle(contentStyle);
	    	  
	    	  HSSFCell ageCell = row.createCell(2);
	    	  ageCell.setCellValue(students.get(i).getAge());
	    	  ageCell.setCellStyle(contentStyle);
	    	  
	    	  HSSFCell telCell = row.createCell(3);
	    	  telCell.setCellValue(students.get(i).getTel());
	    	  telCell.setCellStyle(contentStyle);
			
		}
		
		
		try {
			workbook.write(out);
		} catch (Exception e) {
			System.err.println("文件写入失败");
		}
	}

	@Override
	public List<Student> queryStudentList() throws Exception {
		
		return studentDao.queryStudentList();
	}

}
