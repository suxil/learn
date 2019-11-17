package com.learn.service.web.api.cdm;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.learn.core.common.BaseController;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Api(value = "数据字典 接口")
@RestController
@RequestMapping("/api/v1/cdm-dict")
public class CdmDictController extends BaseController {

}
