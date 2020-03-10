package com.mz.config.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;


/**
* @author 半步 E-mail:renzhichaoshaer@163.com
* @version 创建时间：2017年10月18日 上午10:06:06
* 
*/
@Component
public class MyScheduler {

	@Autowired
    SchedulerFactoryBean schedulerFactoryBean;
    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        startJob1(scheduler); 
        //startJob2(scheduler); 
    }
    private void startJob1(Scheduler scheduler) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class) .withIdentity("job1", "group1").build(); 
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 * * ? * *"); 
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") .withSchedule(scheduleBuilder).build(); 
        scheduler.scheduleJob(jobDetail,cronTrigger); 
    } 
//    private void startJob2(Scheduler scheduler) throws SchedulerException{ 
//        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob2.class) .withIdentity("job2", "group1").build();
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?"); 
//        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1") .withSchedule(scheduleBuilder).build(); 
//        scheduler.scheduleJob(jobDetail,cronTrigger);
//    }
}
