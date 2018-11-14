package com.learn.oauth.repository;

import com.learn.oauth.domain.OrgEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/9/12 0012 11:08
 */
public interface OrgEmployeeRepository extends JpaRepository<OrgEmployee, String> {

}
