package com.learn.activiti;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

import java.util.Date;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/8/25 0025 14:52
 */
public class AutomatedDataDelegate implements JavaDelegate {

    public void execute(DelegateExecution execution) {
        Date now = new Date();
        execution.setVariable("autoWelcomeTime", now);
        System.out.println("Faux call to backend for ["
                + execution.getVariable("fullName") + "]");
    }

}
