package com.bj58.api.vo;

public class RegisterVo {
	   private String userName;
	   private String password; 
	   private String confirm;
	   private Integer age;//注意此处是对象类型，要利用反射注入
	   private String phone;
	   private String email;
	   private String vlidateCode;
	  
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
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVlidateCode() {
		return vlidateCode;
	}
	public void setVlidateCode(String vlidateCode) {
		this.vlidateCode = vlidateCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "registerVo [name=" + userName + ", password=" + password + ", confirm=" + confirm + ", age=" + age
				+ ", phone=" + phone + ", email=" + email + ", vlidateCode=" + vlidateCode + "]";
	}
	
	
}
