package io.github.suxil.dict.util;

import cn.hutool.core.util.ReflectUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import io.github.suxil.dict.annotation.DictField;
import io.github.suxil.dict.annotation.DictFieldData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public final class DictFieldCacheUtil {

    private static final Cache<String, List<DictFieldData>> CACHE = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .build();

    private DictFieldCacheUtil() {
    }

    /**
     * 根据类，获取字典转换元数据集合。缓存已经获取过的类对象
     * @param clazz
     * @return
     */
    public static List<DictFieldData> getDictFieldDataList(Class clazz) {
        String key = clazz.getName();
        List<DictFieldData> dictFieldDataList = CACHE.getIfPresent(key);
        if (dictFieldDataList != null) {
            return dictFieldDataList;
        }

        dictFieldDataList = getDictFieldDataByClass(clazz);

        CACHE.put(key, dictFieldDataList);

        return dictFieldDataList;
    }

    /**
     * 根据类，获取字典转换元数据
     * @param clazz
     * @return
     */
    private static List<DictFieldData> getDictFieldDataByClass(Class clazz) {
        Field[] fields = ReflectUtil.getFields(clazz);

        List<DictFieldData> dictFieldDataList = new ArrayList<>();
        for (Field field : fields) {
            DictField dictField = field.getAnnotation(DictField.class);
            if (dictField == null) {
                continue;
            }

            DictFieldData dictFieldData = new DictFieldData();
            dictFieldData.setKey(dictField.key());
            dictFieldData.setCategory(dictField.category());
            dictFieldData.setFieldName(dictField.fieldName());
            dictFieldData.setTargetFieldName(dictField.targetFieldName());

            if (StringUtils.isEmpty(dictField.fieldName())) {
                dictFieldData.setFieldName(field.getName());
            }

            dictFieldDataList.add(dictFieldData);
        }

        return dictFieldDataList;
    }

    /**
     * 根据类，获取字典转换元数据集合。并设置code集合
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<DictFieldData> getDictFieldDataListAndInitCodeList(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }

        T type = list.get(0);
        List<DictFieldData> dictFieldDataList = DictFieldCacheUtil.getDictFieldDataList(type.getClass());

        for (T t : list) {
            for (DictFieldData dictFieldData : dictFieldDataList) {
                Object value = ReflectUtil.getFieldValue(t, dictFieldData.getFieldName());

                if (value == null) {
                    continue;
                }

                dictFieldData.getCodeList().add(String.valueOf(value));
            }
        }

        return dictFieldDataList;
    }

}
