package io.github.suxil.dict;

import java.util.List;

/**
 * 字典工厂，将各种数据转换为字典数据
 */
public interface DictFactory {

    /**
     * 获取缓存
     * @param key
     * @return
     */
    DictCache getDictCache(String key);

    /**
     * 获取字典服务
     * @param key
     * @return
     */
    DictService getDictService(String key);

    /**
     * 添加字典服务
     * @param key
     * @param dictService
     */
    void addDictService(String key, DictService dictService);

    /**
     * 移除字典服务
     * @param key
     */
    void removeDictService(String key);

    /**
     * 转换集合数据
     * @param list
     * @param <T>
     */
    <T> void convert(List<T> list);

    /**
     * 转换单条记录
     * @param t
     * @param <T>
     */
    <T> void convert(T t);

}
