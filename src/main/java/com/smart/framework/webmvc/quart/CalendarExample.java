package com.smart.framework.webmvc.quart;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

public class CalendarExample {
	
	public static void main(String[] args) throws Exception {
		
SchedulerFactory schedulerFactory=new StdSchedulerFactory();
		
        AnnualCalendar holidays=new AnnualCalendar();
        Calendar laborDay=new GregorianCalendar();//5.1
        laborDay.add(Calendar.MONTH, 5);
        laborDay.add(Calendar.DAY_OF_MONTH, 1);
        
        Calendar nationDay=new GregorianCalendar();//10.1
        nationDay.add(Calendar.MONTH, 10);
        nationDay.add(Calendar.DAY_OF_MONTH, 1);
        
        ArrayList<Calendar> days=new ArrayList<Calendar>();
        holidays.setDaysExcluded(days);
        
        Date runDate=TriggerUtils.getDateOf(0, 0, 10,1,4);//4月1号上午10点
        JobDetail jobDetail=new JobDetail("job1_1","jgroup1", SimpleJob.class);
        SimpleTrigger trigger=new SimpleTrigger("job1_1","jgroup1",
        		runDate,null,SimpleTrigger.REPEAT_INDEFINITELY,60L*60L*1000L);
        trigger.setCalendarName("holidays");
		Scheduler scheduler=schedulerFactory.getScheduler();
		scheduler.addCalendar("holidays", holidays, false, false);
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
		Thread.sleep(10000);
	}

}
