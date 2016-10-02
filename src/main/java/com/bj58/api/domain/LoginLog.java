package com.bj58.api.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 论坛的登录信息
 * @author lenovo
 *
 */
public class LoginLog implements Serializable {
   int loginLogid;
   int userid;
   private String ip;
   private Date loginDate;
   public int getLoginLogid() {
		return loginLogid;
	}
	public void setLoginLogid(int loginLogid) {
		this.loginLogid = loginLogid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
}
