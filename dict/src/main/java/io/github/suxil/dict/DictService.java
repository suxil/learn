package io.github.suxil.dict;

import io.github.suxil.dict.converter.DictConverter;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * 字典缓存注册器
 */
public interface DictService<T> extends DictConverter<T> {

    /**
     * 根据编码查询列表
     *
     * @param category
     * @param codeList
     */
    List<Dict> searchList(String category, List<String> codeList);

}
