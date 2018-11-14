package com.learn.service.web;

import com.learn.api.domain.Company;
import com.learn.api.domain.CompanyImpression;
import com.learn.core.web.BaseController;
import com.learn.service.service.CompanyImpressionService;
import com.learn.service.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@RestController
@RequestMapping("/api")
public class CompanyController extends BaseController<Company> {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyImpressionService companyImpressionService;

    @PostMapping("/companys/operate")
    public Company save(Company company, CompanyImpression companyImpression) {
        company = companyService.save(company);
        companyImpression.setCompanyId(company.getId());
        companyImpressionService.save(companyImpression);
        return company;
    }

}
