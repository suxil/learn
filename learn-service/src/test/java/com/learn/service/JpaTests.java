package com.learn.service;

import com.learn.core.utils.JsonUtils;
import org.junit.Test;
import org.springframework.data.domain.Sort;

public class JpaTests {

    @Test
    public void testSortSerialize() {
        Sort.Order o = Sort.Order.asc("test");
        Sort s = Sort.by(o);
        System.out.println(JsonUtils.toJson(o));
        System.out.println(JsonUtils.toJson(s));
        System.out.println("");
    }

}
