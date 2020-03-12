package com.learn.service.web.api.zyj;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 六十四卦 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Api(value = "六十四卦 接口")
@RestController
@RequestMapping("/api/v1/zyj-sixty-four-gua")
public class ZyjSixtyFourGuaController {

    @RequestMapping
    public void test() {
        throw new RuntimeException("test");
    }

}
