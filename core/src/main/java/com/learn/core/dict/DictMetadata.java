package com.learn.core.dict;

import java.io.Serializable;
import java.util.List;

public interface DictMetadata extends Serializable {

    /**
     * 字典类别
     */
    String getCategory();

    /**
     * 字段名称
     * @return
     */
    String getFieldName();

    /**
     * 目标字段名称
     * @return
     */
    String getTargetFieldName();

    /**
     * 待加载的字典
     * @return
     */
    List<String> getWaitLoadCode();

    /**
     * 缓存的数据
     * @return
     */
    List<Dict> getDictList();

}
