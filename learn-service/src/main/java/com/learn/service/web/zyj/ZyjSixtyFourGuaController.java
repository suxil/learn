package com.learn.service.web.zyj;


import com.learn.core.common.BaseController;
import com.learn.service.service.zyj.IZyjSixtyFourGuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 六十四卦 前端控制器
 * </p>
 *
 * @author luxq
 * @since 2019-08-11
 */
@RestController
@RequestMapping("/generate/zyj-sixty-four-gua")
public class ZyjSixtyFourGuaController extends BaseController {

    @Autowired
    private IZyjSixtyFourGuaService zyjSixtyFourGuaService;

    @GetMapping("")
    public void list() {

    }

}
