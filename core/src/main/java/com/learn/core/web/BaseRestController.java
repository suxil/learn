package com.learn.core.web;

import com.learn.core.domain.BaseDomain;
import com.learn.core.domain.PageDomain;
import com.learn.core.domain.ResponseDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/22 0022 0:09
 */
public abstract class BaseRestController<T extends BaseDomain> extends BaseController<T> {

    private static final Logger log = LoggerFactory.getLogger(BaseRestController.class);

    @GetMapping
    public ResponseDomain getOperate(Map<String, String> params, Pageable pageable) {
        return ResponseDomain.executor(() -> {
            log.info("LOG00000: get page data.");
            return PageDomain.initPage(list(params, pageable));
        });
    }

    @GetMapping("/{id}")
    public ResponseDomain getOperate(@PathVariable("id") String id) {
        return ResponseDomain.executor(() -> {
            log.info("LOG00018: get record.");
            return service.findOne(id);
        });
    }

    @PostMapping
    public ResponseDomain newOperate(T t) {
        return ResponseDomain.executor(() -> {
            log.info("LOG00027: create record.");
            return save(t);
        });
    }

    @PutMapping("/{id}")
    public ResponseDomain putOperate(T t) {
        return ResponseDomain.executor(() -> {
            log.info("LOG00036: update record.");
            return update(t);
        });
    }

    @PatchMapping("/{id}")
    public ResponseDomain patchOperate(T t) {
        return ResponseDomain.executor(() -> {
            log.info("LOG00045: update record.");
            return update(t);
        });
    }

    @DeleteMapping("/{id}")
    public ResponseDomain delOperate(String id) {
        return ResponseDomain.executor(() -> {
            log.info("LOG00054: delete record.");
            return delete(id);
        });
    }

}
