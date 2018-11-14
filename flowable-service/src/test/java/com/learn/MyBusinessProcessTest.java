package com.learn;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.test.Deployment;
import org.flowable.engine.test.FlowableRule;
import org.flowable.task.api.Task;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/8/26 0026 9:16
 */
public class MyBusinessProcessTest {

    @Rule
    public FlowableRule flowableRule = new FlowableRule();

    @Test
    @Deployment
    public void holidayRequestExample() {
        RuntimeService runtimeService = flowableRule.getRuntimeService();
        runtimeService.startProcessInstanceByKey("holidayRequest");

        TaskService taskService = flowableRule.getTaskService();
        Task task = taskService.createTaskQuery().singleResult();
        assertEquals("My Task", task.getName());

        taskService.complete(task.getId());
        assertEquals(0, runtimeService.createProcessInstanceQuery().count());
    }

}
