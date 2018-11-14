package com.learn.flowable.web;

import com.learn.flowable.service.QuickStartService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/8/26 0026 14:32
 */
@RestController
public class QuickStartController {

//    private Idm
    @Autowired
    private QuickStartService quickStartService;

    @PostMapping("/quick-start/deploy")
    public Object deploy() {
        return quickStartService.deploy();
    }

    @PostMapping("/quick-start/start")
    public Object start() {
        return quickStartService.start();
    }

    @GetMapping("/quick-start/query-candidate")
    public List<Task> queryCandidate() {
        return quickStartService.queryCandidate();
    }

}
