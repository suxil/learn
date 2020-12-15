package io.github.suxil.core.util;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
@Slf4j
public class BeanUtils {

    private static final List<String> DEFAULT_FILTER_FIELDS = Arrays.asList("id", "createTime", "updateTime", "createName", "updateName", "isDelete", "version");

    private BeanUtils() {
    }

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
    public static <T> T newInstance(Class<T> clazz) {
        try {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(clazz);
            enhancer.setCallback(new MethodInterceptorImpl());
            return (T) enhancer.create();
        } catch (Throwable e) {
            log.error("newInstance: " + e.getMessage());
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
        BeanMap map = BeanMap.create(object);
        map.put(object.getClass().getName(), object);
        return map;
    }

    /**
     * 获取对象对应字段的属性值
     *
     * @param bean
     * @param fieldName
     * @return
     */
    public static Object getProperties(Object bean, String fieldName) {
        try {
            BeanMap map = getBeanMap(bean);
            return map.get(fieldName);
        } catch (Exception e) {
            log.error("getProperties: " + e.getMessage());
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
    public static void setProperties(Object bean, String fieldName, Object value) {
        try {
            BeanMap map = getBeanMap(bean);
            map.put(fieldName, value);
        } catch (Exception e) {
            log.error("setProperties: " + e.getMessage());
        }
    }

    /**
     * 拷贝对象属性到clazz实例，过滤掉基础字段
     *
     * @param source
     * @param clazz
     */
    public static <T> T beanCopy(Object source, Class<T> clazz) {
        T target = newInstance(clazz);
        beanCopy(source, target);
        return target;
    }

    /**
     * 拷贝对象属性到clazz实例，过滤掉基础字段
     *
     * @param source
     * @param clazz
     */
    public static <T> T beanCopy(Map<String, Object> source, Class<T> clazz) {
        T target = newInstance(clazz);
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
        for (Object key : map.keySet()) {
            if (!DEFAULT_FILTER_FIELDS.contains(key)) {
                mapTarget.put(key, map.get(key));
            }
        }
    }

    /**
     * 拷贝两个对象之间的属性，过滤掉基础字段
     *
     * @param source
     * @param target
     */
    public static void beanCopy(Map<String, Object> source, Object target) {
        BeanMap mapTarget = getBeanMap(target);
        for (String key : source.keySet()) {
            if (!DEFAULT_FILTER_FIELDS.contains(key)) {
                mapTarget.put(key, source.get(key));
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

}
