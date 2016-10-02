package com.bj58.api.services.imp;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bj58.api.domain.User;
import com.bj58.api.services.IUserService;



//指定测试运行器（spring提供的）
@RunWith(SpringJUnit4ClassRunner.class) //基于Junit4的spring测试框架
@ContextConfiguration(locations={"/applicationContext.xml"})//启动Spring容器
public class UserServiceImpTest {
	//注入spring容器中的bean
	@Autowired
	private IUserService userService;

	
	
	//标注测试方法
	@Test
	public void testHasMatchUser() {
		boolean b1=userService.hasMatchUser("admin","123456");
		boolean b2=userService.hasMatchUser("admin", "1111");
		assertTrue(b1);//静态导入
		assertTrue(!b2);	
	}

	@Test
	public void testFindUserByUserName() {
		User user=userService.findUserByUserName("admin");
		assertEquals(user.getUserName(), "admin");
	}

	@Test
	public void testLoginSuccess() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		userService.addUser("lsj", "123");
	}

}
