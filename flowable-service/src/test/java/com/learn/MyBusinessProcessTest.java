package com.learn;

import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.Process;
import org.flowable.bpmn.model.UserTask;
import org.flowable.common.engine.api.io.InputStreamProvider;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.test.Deployment;
import org.flowable.engine.test.FlowableRule;
import org.flowable.task.api.Task;
import org.junit.Rule;
import org.junit.Test;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/8/26 0026 9:16
 */
public class MyBusinessProcessTest {

//    @Rule
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

    @Test
    public void testConvertBpmnXml() {
        final InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SeamanPrepareZyhzTestProcess.bpmn20.xml");

        BpmnXMLConverter bpmnXMLConverter = new BpmnXMLConverter();

        BpmnModel bpmnMode = bpmnXMLConverter.convertToBpmnModel(() -> inputStream, false, false);
        Process process = bpmnMode.getProcesses().get(0);
        Collection<FlowElement> flowElements  = process.getFlowElements();
        for (FlowElement flowElement : flowElements) {
            if (flowElement instanceof UserTask) {
                UserTask u = (UserTask) flowElement;
                List outgoingFlows = u.getOutgoingFlows();
                System.err.println("outgoingFlows:" + outgoingFlows);
            }
            System.err.println(flowElement.getId() + "--->>>>" + flowElement.getName());
        }

        System.out.println("test");

    }

}
