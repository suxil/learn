package com.learn.flowable.repository;

import com.learn.flowable.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/8/26 0026 10:47
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByUsername(String username);

}
