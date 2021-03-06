package com.smart.framework.webmvc.quart;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerRunner {
	
	public static void main(String[] args) throws Exception {
		//创建一个JobDetail实例，指定SimpleJob
		JobDetail jobDetail=new JobDetail("job1_1","jgroup1", SimpleJob.class);
		SimpleTrigger simpleTrigger=new SimpleTrigger("job1_1","jgroup1");
		simpleTrigger.setStartTime(new Date());
		simpleTrigger.setRepeatInterval(2000);
		simpleTrigger.setRepeatCount(100);
		
		SchedulerFactory schedulerFactory=new StdSchedulerFactory();
		
		Scheduler scheduler=schedulerFactory.getScheduler();
		scheduler.scheduleJob(jobDetail, simpleTrigger);
		scheduler.start();
	}

}
