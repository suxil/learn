package com.learn.service.web;

import com.learn.api.domain.CompanyImpression;
import com.learn.core.web.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@RestController
@RequestMapping("/companys/impression")
public class CompanyImpressionController extends BaseController<CompanyImpression> {

}
