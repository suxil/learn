package io.github.suxil.core.dict;

import java.io.Serializable;

public interface Dict extends Serializable {

    /**
     * 字典key
     */
    String getKey();

    /**
     * 字典类别
     */
    String getCategory();

    /**
     * 序号
     */
    Integer getSeq();

    /**
     * 编码
     */
    String getCode();

    /**
     * 名称
     */
    String getName();

    /**
     * 是否已缓存
     */
    boolean isExist();

}
