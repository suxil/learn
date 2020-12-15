package io.github.suxil.core.util;

import io.github.suxil.core.dict.support.DictImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BeanUtilsTest {

    @Test
    public void beanCopyTest() {
        DictImpl source = new DictImpl();
        source.setCode("code");

        Map map = new HashMap();
        map.put("code", "code1");

        DictImpl target = new DictImpl();
//        BeanUtils.setProperties(target, "code", "code1");
        BeanUtils.beanCopy(map, target);

        System.out.println();
    }

}
