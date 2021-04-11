package io.github.suxil.dict.util;

import io.github.suxil.core.consumer.SpringContextHolder;
import io.github.suxil.dict.DictFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j
public final class DictUtil {

    private DictUtil() {
    }

    /**
     * 数据字典转换
     * @param list
     * @param <T>
     */
    public static <T> void convert(List<T> list) {
        DictFactory dictFactory = SpringContextHolder.getBean(DictFactory.class);
        if (dictFactory == null) {
            return;
        }

        dictFactory.convert(list);
    }

    /**
     * 数据字典转换
     * @param t
     * @param <T>
     */
    public static <T> void convert(T t) {
        convert(Collections.singletonList(t));
    }

}
