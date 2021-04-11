package io.github.suxil.dict.annotation;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DictFieldData {

    /**
     * 缓存key
     */
    private String key;
    /**
     * 字典类别
     */
    private String category;
    /**
     * 字段名称
     * 当字段为空时，使用当前字段属性名
     */
    private String fieldName;
    /**
     * 目标字段名称
     */
    private String targetFieldName;
    /**
     * 编号集合
     */
    private List<String> codeList = new ArrayList<>();

}
