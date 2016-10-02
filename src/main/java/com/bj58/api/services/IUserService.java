package com.bj58.api.services;

import com.bj58.api.domain.User;

public interface IUserService {
	
	public boolean hasMatchUser(String userName,String password);
	public User findUserByUserName(String userName);
	public void loginSuccess(User user);
	public void addUser(String userName, String password);
	public void addUser(User user);
}
