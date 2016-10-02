package com.bj58.api.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bj58.api.Dao.LoginLogDao;
import com.bj58.api.Dao.UserDao;
import com.bj58.api.domain.LoginLog;
import com.bj58.api.domain.User;
import com.bj58.api.services.IUserService;



@Service //将Userservice标注为一个服务层的Bean
public class UserServiceImp implements IUserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	/**
	 * 用于检查用户名/密码的准确性
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean hasMatchUser(String userName,String password) {
		int matchCount=userDao.getMatchCount(userName, password);
		return matchCount>0;
		
	}
	/**
	 * 以用户名为条件加载User对象
	 * @param userName
	 * @return
	 */
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	/**
	 * 在用户登录成功后调用，更新用户最后登录时间和Ip信息同时记录登录日志
	 * @param user
	 */
	public void loginSuccess(User user){
		//此处一个bug，因为user的初始积分没有（null），会抛出异常
		user.setCredits(5+user.getCredits());//登录成功后，积分加5
		LoginLog loginLog=new LoginLog();
		loginLog.setUserid(user.getUserid());
		loginLog.setIp(user.getLastlp());
		loginLog.setLoginDate(user.getLastVisit());
		userDao.updateLogininfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}
	/**
	 * 祖册用户
	 */
	@Override
	public void addUser(String userName, String password) {
		userDao.addUser(userName, password);
	}
	@Override
	public void addUser(User user) {
		userDao.addUser(user.getUserName(), user.getPassword());
	}

}
