package io.github.suxil.dict;

import java.io.Serializable;

public interface Dict extends Serializable {

    /**
     * 字典key
     */
    String getKey();

    /**
     * 序号
     */
    Integer getSeq();

    /**
     * 字典类别
     */
    String getCategory();

    /**
     * 编码
     */
    String getCode();

    /**
     * 名称
     */
    String getName();

    /**
     * 备注
     */
    String getRemark();

}
