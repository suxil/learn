package io.github.suxil.dict.converter;

import io.github.suxil.dict.Dict;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 将业务基础数据转换为字典数据
 * @param <T>
 */
public interface DictConverter<T> {

    default List<Dict> convert(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }

        List<Dict> result = new ArrayList<>(list.size());
        for (T t : list) {
            result.add(convert(t));
        }
        return result;
    }

    Dict convert(T t);

}
