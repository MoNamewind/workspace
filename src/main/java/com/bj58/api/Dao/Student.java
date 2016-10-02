package com.bj58.api.Dao;

public class Student {
  
	public int id;
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", tel=" + tel + "]";
	}
	public String name;
	public int age; 
	public String tel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

}
