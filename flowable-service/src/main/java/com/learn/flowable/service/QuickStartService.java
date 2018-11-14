package com.learn.flowable.service;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/8/26 0026 14:24
 */
@Service
public class QuickStartService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskService;

    public Deployment deploy() {
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("FinancialReportProcess.bpmn20.xml")
                .deploy();
        return deployment;
    }

    public ProcessInstance start() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("financialReport");
        return processInstance;
    }

    public List<Task> queryCandidate() {
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("accountancy").list();
        for (int i=0; i<tasks.size(); i++) {
            System.out.println((i+1) + ") " + tasks.get(i).getName());
        }
        return tasks;
    }

}
