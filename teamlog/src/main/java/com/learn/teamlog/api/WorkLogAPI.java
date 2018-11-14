package com.learn.teamlog.api;

import com.learn.core.domain.ResponseDomain;
import com.learn.teamlog.domain.WorkLog;
import com.learn.teamlog.service.WorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/7/3 0003 22:54
 */
@RestController
public class WorkLogAPI {

    @Autowired
    private WorkLogService workLogService;

    @GetMapping("/api/v1/work-logs")
    public ResponseDomain index(@RequestParam Map<String, String> params, Pageable pageable) {
        Page<WorkLog> page = workLogService.list(params, pageable);

        //WebUtils.getResponse().setHeader("Access-Control-Allow-Origin", "*");

        return ResponseDomain.success(page);
    }

    @GetMapping("/api/v1/work-logs/{id}")
    public ResponseDomain index(@PathVariable("id") String id) {
        WorkLog workLog = workLogService.findOne(id);
        return ResponseDomain.success(workLog);
    }

    @PostMapping("/api/v1/work-logs")
    public ResponseDomain save(@RequestBody WorkLog workLog) {
        workLogService.save(workLog);
        return ResponseDomain.success(workLog);
    }

    @PutMapping("/api/v1/work-logs")
    public ResponseDomain update(@RequestBody WorkLog workLog) {
        workLogService.save(workLog);
        return ResponseDomain.success(workLog);
    }

    @DeleteMapping("/api/v1/work-logs/{id}")
    public ResponseDomain delete(@PathVariable("id") String id) {
        workLogService.logicalDelete(id);
        return ResponseDomain.success(id);
    }

}
