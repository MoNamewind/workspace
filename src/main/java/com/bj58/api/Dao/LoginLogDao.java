package com.bj58.api.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.bj58.api.domain.LoginLog;

/**
 * 负责记录用户的登录日志
 * @author lenovo
 *
 */
@Repository
public class LoginLogDao {
	@Autowired //自动注入jdbcTemplate的bean
	private JdbcTemplate jdbcTemplate;
	/**
	 * 完成登录日志的插入操作
	 * @param loginLog
	 */
	public void insertLoginLog(LoginLog loginLog) {
		String  sqlstr="INSERT INTO t_login_log(user_id,ip,login_datetime) "
			+" VALUES(?,?,?)";
		Object[] args={loginLog.getUserid(),loginLog.getIp(),loginLog.getLoginDate()};
		 jdbcTemplate.update(sqlstr, args);
	}

}
