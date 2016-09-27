package com.smart.framework.webmvc.shiro;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloShiro {
	
	private static final Logger logger=LoggerFactory.getLogger(HelloShiro.class);
    public static void main(String[] args) {
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject=SecurityUtils.getSubject();
		
		//登录
		UsernamePasswordToken token=new UsernamePasswordToken("shiro","201314");
		try{
			subject.login(token);
		}catch (Exception e) {
			logger.info("登录失败！");
			return;
		}
		logger.info("登录成功！Hello"+subject.getPrincipal());
		
		subject.logout();
	}
    
    @Test
    public void test(){
    	
    	System.out.println("-------使用数据库作为登录------------");
    	
    	Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject=SecurityUtils.getSubject();
		
		//登录
		//UsernamePasswordToken token=new UsernamePasswordToken("shiro","201314");
		UsernamePasswordToken token=new UsernamePasswordToken("zhang","123");
		try{
			subject.login(token);
		}catch (Exception e) {
			logger.info("登录失败！");
			return;
		}
		logger.info("登录成功！Hello"+subject.getPrincipal());
		
		subject.logout();
    	
    }
}
