package com.learn.service.web.api.tem;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.learn.core.common.BaseController;

/**
 * <p>
 * 自己的生活记录 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Api(value = "自己的生活记录 接口")
@RestController
@RequestMapping("/api/v1/tem-self-record")
public class TemSelfRecordController extends BaseController {

}
