package com.learn.oauth.service;

import com.learn.oauth.domain.OrgEmployee;
import com.learn.oauth.repository.OrgEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/9/12 0012 11:08
 */
@Service
public class OrgEmployeeService {

  @Autowired
  private OrgEmployeeRepository orgEmployeeRepository;

  public OrgEmployee findByName(String username) {
    OrgEmployee orgEmployee = new OrgEmployee();
    orgEmployee.setEmpName(username);
    ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.DEFAULT);
    Example<OrgEmployee> example = Example.of(orgEmployee, matcher);
    Optional<OrgEmployee> optional = orgEmployeeRepository.findOne(example);
    return optional.get();
  }

}
