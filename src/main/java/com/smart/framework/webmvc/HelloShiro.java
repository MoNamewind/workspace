package com.smart.framework.webmvc;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloShiro {
	
	private static final Logger logger=LoggerFactory.getLogger(HelloShiro.class);
    public static void main(String[] args) {
    	//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager 
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		//2、得到SecurityManager实例 并绑定给SecurityUtils
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject=SecurityUtils.getSubject();
		
		//登录
		UsernamePasswordToken token=new UsernamePasswordToken("shiro","201314");
		try{
			//4、登录，即身份验证 
			subject.login(token);
		}catch (Exception e) {
			logger.info("登录失败！");
			return;
		}
		logger.info("登录成功！Hello"+subject.getPrincipal());
		
		subject.logout();
	}
}
