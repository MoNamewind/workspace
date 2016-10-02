package com.bj58.api.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户信息
 * 领域对象一般要实现Serializable接口，以便可以序列化
 * @author lenovo
 *
 */
public class User implements Serializable{
  
public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getLastlp() {
		return lastlp;
	}
	public void setLastlp(String lastlp) {
		this.lastlp = lastlp;
	}
	public Date getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}
    private int userid;
    public  User() {}
    public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
   private String userName;
   private String password;
   private int credits;
   private String lastlp;
   private Date lastVisit;
	
}
