package com.smart.framework.webmvc.quart;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * 定时发邮件
 * @author 58
 *
 */
public class SimpleJob implements Job {
    
	//实现job接口的方法

	public void execute(JobExecutionContext jobctx) throws JobExecutionException {
		
		System.out.println(jobctx.getTrigger().getName()+"triggered.time is"+new Date());
	}

}
