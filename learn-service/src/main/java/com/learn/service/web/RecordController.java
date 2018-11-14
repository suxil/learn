package com.learn.service.web;

import com.learn.core.web.BaseRestController;
import com.learn.api.domain.Record;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/1/2 0002.
 */
@RestController
@RequestMapping("/records")
public class RecordController extends BaseRestController<Record> {

}
