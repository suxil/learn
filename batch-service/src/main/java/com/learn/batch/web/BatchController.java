package com.learn.batch.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
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
            log.error("start JobExecutionAlreadyRunningException" + e.getMessage());
        } catch (JobRestartException e) {
            log.error("start JobRestartException" + e.getMessage());
        } catch (JobInstanceAlreadyCompleteException e) {
            log.error("start JobInstanceAlreadyCompleteException" + e.getMessage());
        } catch (JobParametersInvalidException e) {
            log.error("start JobParametersInvalidException" + e.getMessage());
        }
    }

}
