package com.bj58.api.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.bj58.api.domain.User;


@Repository  //通过spring注解定义一个Dao
public class UserDao {
	@Autowired //自动注入jdbcTemplate的bean
	private JdbcTemplate jdbcTemplate;
	/**
	 * 根据用户名和密码获取匹配的用户数
	 * 
	 * 
	 * @param userName
	 * @param password
	 * @return 1.正确，0.错误
	 */
	public int getMatchCount(String userName,String  password){
		String  sqlstr="SELECT count(*) FROM t_user where user_name=? and password=?";
	return jdbcTemplate.queryForInt(sqlstr, new Object[]{userName,password});
		
	}
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public User findUserByUserName(final String userName) {
		//根据用户名查询用户的sql语句
		String  sqlstr="SELECT user_id,user_name,credits FROM t_user where user_name=?";
		final User user=new User();
		jdbcTemplate.query(sqlstr, new Object[]{userName},
				//匿名类方式实现回调函数
				new RowCallbackHandler(){
					public void processRow(ResultSet rs) throws SQLException {
						user.setUserid(rs.getInt("user_id"));
						user.setUserName(userName);
						user.setCredits(rs.getInt("credits"));
						
					}
		});
		return user;
	}
	public void addUser(final String userName,final String password) {
		//根据用户名查询用户的sql语句
		String  sqlstr="insert into t_user(user_name,password) VALUES(?,?)";
	    jdbcTemplate.update(sqlstr, new Object[]{userName,password});
	}
	
	
	
	/**
	 * 更新用户积分，最后登录IP以及最后登录时间
	 */
	public void updateLogininfo(User user){
		String  sqlstr="UPDATE  t_user SET last_visit=? ,last_ip=?,credits=? "//注意：空格，不然连在一起了
			+" where user_id=?";
		 jdbcTemplate.update(sqlstr, new Object[]{user.getLastVisit(),user.getLastlp(),user.getCredits(),user.getUserid()});
	}
}
