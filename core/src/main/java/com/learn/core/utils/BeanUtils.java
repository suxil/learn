package com.learn.core.utils;

import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
public class BeanUtils {

    private static final ConcurrentHashMap<String, BeanMap> BEAN_MAP = new ConcurrentHashMap<String, BeanMap>();
    public static final List<String> DEFAULT_FILTER_FIELDS = Arrays.asList("id", "createTime", "updateTime", "createName", "updateName", "isDelete", "version");

    private static class MethodInterceptorImpl implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            return methodProxy.invokeSuper(o, objects);
        }
    }

    /**
     * 创建class实例
     *
     * @param clazz
     * @return
     */
    public static Object newInstance(Class clazz) {
        try {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(clazz);
            enhancer.setCallback(new MethodInterceptorImpl());
            return enhancer.create();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new Error(e.getMessage());
        }
    }

    /**
     * 获取缓存的bean对象
     *
     * @param object
     * @return
     */
    public static BeanMap getBeanMap(Object object) {
        if (BEAN_MAP.contains(object)) {
            BeanMap map = BEAN_MAP.get(object.getClass().getName());
            map.setBean(object);
            return map;
        } else {
            BeanMap map = BeanMap.create(object);
            map.put(object.getClass().getName(), object);
            return map;
        }
    }

    /**
     * 获取对象对应字段的属性值
     *
     * @param bean
     * @param fieldName
     * @return
     */
    public static Object getPropertie(Object bean, String fieldName) {
        try {
            BeanMap map = getBeanMap(bean);
            return map.get(fieldName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置对象对应字段的属性值
     *
     * @param bean
     * @param fieldName
     * @param value
     */
    public static void setPropertie(Object bean, String fieldName, Object value) {
        try {
            BeanMap map = getBeanMap(bean);
            map.put(fieldName, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 拷贝对象属性到clazz实例，过滤掉基础字段
     *
     * @param source
     * @param clazz
     */
    public static Object beanCopy(Object source, Class<?> clazz) {
        Object target = newInstance(clazz);
        beanCopy(source, target);
        return target;
    }

    /**
     * 拷贝两个对象之间的属性，过滤掉基础字段
     *
     * @param source
     * @param target
     */
    public static void beanCopy(Object source, Object target) {
        BeanMap map = getBeanMap(source);
        BeanMap mapTarget = getBeanMap(target);
        for (Object o : map.keySet()) {
            if (!DEFAULT_FILTER_FIELDS.contains(o)) {
                mapTarget.put(o, map.get(o));
            }
        }
    }

    /**
     * 将bean转换为map对象
     *
     * @param bean
     * @return
     */
    public static Map<String, Object> beanToMap(Object bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = getBeanMap(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key.toString(), beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将map转换为bean对象
     *
     * @param map
     * @param bean
     * @return
     */
    public static Object mapToBean(Map<String, Object> map, Object bean) {
        BeanMap beanMap = getBeanMap(bean);
        beanMap.putAll(map);
        return bean;
    }

}
