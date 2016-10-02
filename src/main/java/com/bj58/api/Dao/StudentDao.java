package com.bj58.api.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 查询学生信息
 * @author 58
 *
 */
@Repository
public class StudentDao {

	public static  List<Student>  queryStudentList() throws Exception{
		List<Student> stulist=new ArrayList<Student>();
		
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/test";
		Connection connection=DriverManager.getConnection(url,"root", "root");
		
		Statement statement = connection.createStatement();
		String sql="select * from student";
		ResultSet query = statement.executeQuery(sql);
		while (query.next()) {
			Student student=new Student();
			student.setId(query.getInt(1));
			student.setName(query.getString(2));
			student.setAge(query.getInt(3));
			student.setTel(query.getString(4));
			stulist.add(student);
		}
		connection.close();
		return stulist;
		
	}
	
	public static void main(String[] args) throws Exception {
		List<Student> students=queryStudentList();
		for (Student student : students) {
			System.out.println(student);
		}
		
	}
	
}
