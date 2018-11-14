package com.learn.service.quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 17:02
 */
public class UsingTests {

    @Test
    public void test() {
        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();

            // define the job and tie it to our MyJob class
//            JobDetail job = new Job(MyJob.class)
//                    .withIdentity("job1", "group1")
//                    .build();
//
//            // Trigger the job to run now, and then repeat every 40 seconds
//            Trigger trigger = newTrigger()
//                    .withIdentity("trigger1", "group1")
//                    .startNow()
//                    .withSchedule(simpleSchedule()
//                            .withIntervalInSeconds(40)
//                            .repeatForever())
//                    .build();
//
//            // Tell quartz to schedule the job using our trigger
//            scheduler.scheduleJob(job, trigger);

            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }

    }

    @Test
    public void testQuickStart() {

    }

}
