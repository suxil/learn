package io.github.suxil.dict.support;

import cn.hutool.core.util.ReflectUtil;
import io.github.suxil.dict.Dict;
import io.github.suxil.dict.DictCache;
import io.github.suxil.dict.DictFactory;
import io.github.suxil.dict.DictService;
import io.github.suxil.dict.annotation.DictFieldData;
import io.github.suxil.dict.util.DictFieldCacheUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class DefaultDictFactory implements DictFactory {

    /**
     * 字典数据服务
     */
    private final ConcurrentMap<String, DictService> DICT_SERVICE_MAP = new ConcurrentHashMap<>();
    /**
     * 字典数据缓存
     */
    private final ConcurrentMap<String, DictCache> DICT_CACHE_MAP = new ConcurrentHashMap<>();

    // 字典缓存实现类
    private Class<? extends DictCache> dictCacheClass = DefaultDictCache.class;

    public DefaultDictFactory() {
    }

    public DefaultDictFactory(Class<DictCache> dictCacheClass) {
        this.dictCacheClass = dictCacheClass;
    }

    @Override
    public DictCache getDictCache(String key) {
        return DICT_CACHE_MAP.get(key);
    }

    @Override
    public DictService getDictService(String key) {
        return DICT_SERVICE_MAP.get(key);
    }

    @Override
    public void addDictService(String key, DictService dictService) {
        DICT_SERVICE_MAP.put(key, dictService);

        DictCache dictCache = ReflectUtil.newInstance(dictCacheClass);
        DICT_CACHE_MAP.put(key, dictCache);
    }

    @Override
    public void removeDictService(String key) {
        DICT_SERVICE_MAP.remove(key);
        DICT_CACHE_MAP.remove(key);
    }

    @Override
    public <T> void convert(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }

        List<DictFieldData> dictFieldDataList = DictFieldCacheUtil.getDictFieldDataListAndInitCodeList(list);

        // 缓存字典数据
        for (DictFieldData dictFieldData : dictFieldDataList) {
            String key = dictFieldData.getKey();

            DictCache dictCache = getDictCache(key);
            if (dictCache == null) {
                continue;
            }
            DictService dictService = getDictService(key);
            if (dictService == null) {
                continue;
            }

            List<String> codeList = dictFieldData.getCodeList();

            if (CollectionUtils.isEmpty(codeList)) {
                continue;
            }

            // 查询字典数据
            List<Dict> dictList = dictService.searchList(dictFieldData.getCategory(), codeList);
            if (CollectionUtils.isNotEmpty(dictList)) {
                dictCache.update(key, dictList);
            }
        }

        // 设置字典值
        for (T t : list) {
            for (DictFieldData dictFieldData : dictFieldDataList) {
                String key = dictFieldData.getKey();
                String category = dictFieldData.getCategory();

                DictCache dictCache = getDictCache(key);
                if (dictCache == null) {
                    continue;
                }

                List<Dict> cacheList = dictCache.get(key, category);
                if (CollectionUtils.isEmpty(cacheList)) {
                    continue;
                }

                Object v = ReflectUtil.getFieldValue(t, dictFieldData.getFieldName());

                if (v == null) {
                    continue;
                }

                String value = String.valueOf(v);

                List<Dict> findList = cacheList.stream()
                        .filter(item -> value.equals(item.getCode()))
                        .collect(Collectors.toList());

                if (CollectionUtils.isEmpty(findList)) {
                    continue;
                }

                Dict dict = findList.get(0);

                ReflectUtil.setFieldValue(t, dictFieldData.getTargetFieldName(), dict.getName());
            }
        }
    }

    @Override
    public <T> void convert(T t) {
        List<T> list = Collections.singletonList(t);

        convert(list);
    }

}
