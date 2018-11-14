package com.learn.service.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 17:25
 */
public class MyJob implements Job {

    public MyJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("Hello World!  MyJob is executing.");
    }

}
