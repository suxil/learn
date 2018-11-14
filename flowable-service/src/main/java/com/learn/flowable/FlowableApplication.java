package com.learn.flowable;

import com.learn.flowable.service.MyService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/6/28 0028 0:09
 */
//@Configuration
//@ComponentScan(basePackages = {"com.learn.flowable", "org.flowable"})
@SpringBootApplication
public class FlowableApplication {

    @Autowired
    private MyService myService;

    public static void main(String[] args) {
        SpringApplication.run(FlowableApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(final RepositoryService repositoryService, final RuntimeService runtimeService, final TaskService taskService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                myService.createDemoUsers();

//                System.out.println("Number of process definitions : " + repositoryService.createProcessDefinitionQuery().count());
//                System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//                runtimeService.startProcessInstanceByKey("oneTaskProcess");
//                System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
            }
        };
    }

//    @Process
//    @Bean
//    public TaskExecutor processTaskExecutor() {
//        return new SimpleAsyncTaskExecutor();
//    }
//
//    @Cmmn
//    @Bean
//    public TaskExecutor cmmnTaskExecutor() {
//        return new SyncTaskExecutor();
//    }

}
