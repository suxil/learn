package com.learn.core.util;

import org.springframework.util.CollectionUtils;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Title:
 * Description:
 * date: 2019/12/31 22:05
 *
 * @author suxi
 * @version V1.0
 */
public final class TreeUtils {

    private TreeUtils() {
    }

    /**
     * Description: 遍历所有节点
     * date: 2019/12/19 15:55
     *
     * @author lu_it
     * @version V1.0
     * @param treeList
     * @param getChildFunction
     * @param consumer
     * @return void
     */
    public static <T> void filterTree(List<T> treeList, @Nullable Function<T, List<T>> getChildFunction, @Nullable Consumer<T> consumer) {
        if (CollectionUtils.isEmpty(treeList)) {
            return;
        }

        for (T t : treeList) {
            List<T> child = getChildFunction.apply(t);
            if (!CollectionUtils.isEmpty(child)) {
                filterTree(child, getChildFunction, consumer);
            }
            consumer.accept(t);
        }
    }

    /**
     * Description: 转换树型结构
     * date: 2019/12/19 12:38
     *
     * @author lu_it
     * @version V1.0
     * @param dataList
     * @param keyFunction
     * @param parentKeyFunction
     * @param setChildConsumer
     * @return java.util.List<T>
     */
    public static <T, R> List<T> convertToTree(List<T> dataList, @Nullable Function<T, R> keyFunction, @Nullable Function<T, R> parentKeyFunction, @Nullable BiConsumer<T, List<T>> setChildConsumer) {
        if (CollectionUtils.isEmpty(dataList)) {
            return new ArrayList<>();
        }

        Map<R, R> keyMap = new HashMap<>();
        Map<R, List<T>> parentMap = new HashMap<>();
        init(dataList, keyFunction, parentKeyFunction, keyMap, parentMap);

        // 递归获取一级节点信息
        List<T> treeList = new ArrayList<>();
        for (T t : dataList) {
            R key = keyFunction.apply(t);
            R parentKey = parentKeyFunction.apply(t);

            // parentKey不存在的为一级节点(可能存在没有子节点的一级节点)
            if (!keyMap.containsKey(parentKey)) {
                List<T> child = parentMap.get(key);
                List<T> childList = recursiveGetTopNode(parentMap, keyFunction, setChildConsumer, child);
                setChildConsumer.accept(t, childList);

                treeList.add(t);
            }
        }

        return treeList;
    }

    /**
     * Description: 递归获取非一级节点信息
     * date: 2019/12/19 12:20
     *
     * @author lu_it
     * @version V1.0
     * @param parentMap
     * @param child
     * @return java.util.List<T>
     */
    private static <T, R> List<T> recursiveGetTopNode(Map<R, List<T>> parentMap, Function<T, R> keyFunction, BiConsumer<T, List<T>> setChildConsumer, List<T> child) {
        List<T> topNodeList = new ArrayList<>();
        if (CollectionUtils.isEmpty(child)) {
            return topNodeList;
        }

        for (T t : child) {
            R key = keyFunction.apply(t);

            if (parentMap.containsKey(key)) {
                List<T> currentChild = parentMap.get(key);
                if (!CollectionUtils.isEmpty(currentChild)) {
                    List<T> currentTopList = recursiveGetTopNode(parentMap, keyFunction, setChildConsumer, currentChild);
                    setChildConsumer.accept(t, currentTopList);
                }
            }

            topNodeList.add(t);
        }

        return topNodeList;
    }

    /**
     * Description:
     * date: 2019/12/19 12:16
     *
     * @author lu_it
     * @version V1.0
     * @param dataList
     * @param keyFunction
     * @param parentKeyFunction
     * @param keyMap 存储所有记录的key,parentKey不存在的为一级节点
     * @param parentMap 存储所有包含子节点的parentKey和对应的节点信息
     * @return void
     */
    private static <T, R> void init(List<T> dataList, Function<T, R> keyFunction, Function<T, R> parentKeyFunction, Map<R, R> keyMap, Map<R, List<T>> parentMap) {
        if (CollectionUtils.isEmpty(dataList)) {
            return;
        }

        for (T t : dataList) {
            R key = keyFunction.apply(t);
            R parentKey = parentKeyFunction.apply(t);
            if (parentMap.containsKey(parentKey)) {
                parentMap.get(parentKey).add(t);
            } else {
                List<T> childList = new ArrayList<>();
                childList.add(t);
                parentMap.put(parentKey, childList);
            }
            keyMap.put(key, key);
        }
    }

}
