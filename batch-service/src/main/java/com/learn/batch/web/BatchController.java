package com.learn.batch.web;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importUserJob;

    @RequestMapping("/batch/start/job")
    public void start() {
        JobParameters jobParameters = new JobParameters();
//        JobExecution jobExecution = jobRepository.getLastJobExecution("importUserJob", jobParameters);
//        JobInstance jobInstance = jobExecution.getJobInstance();
        try {
            jobLauncher.run(importUserJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }

}
