package com.mz.config.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
* @author 半步 E-mail:renzhichaoshaer@163.com
* @version 创建时间：2017年10月18日 上午10:09:12
* 
*/
public class ScheduledJob implements  Job {

	private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    } 
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException { 
        System.out.println("AAAA: The time is now " + dateFormat().format(new Date())); 
    }
}
