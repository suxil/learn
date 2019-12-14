package com.learn.core.utils;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectUtils {

    /**
     * 通过field获取字段的get方法
     * @param obj
     * @param field
     * @param parameterTypes
     * @return
     */
    public static Method getByFieldGetMethod(Object obj, Field field, Class<?>... parameterTypes) {
        if (field != null) {
            return getByFieldGetMethod(obj, field.getName(), parameterTypes);
        }
        return null;
    }

    /**
     * 通过field获取字段的set方法
     * @param obj
     * @param field
     * @param parameterTypes
     * @return
     */
    public static Method getByFieldSetMethod(Object obj, Field field, Class<?>... parameterTypes) {
        if (field != null) {
            return getByFieldSetMethod(obj, field.getName(), parameterTypes);
        }
        return null;
    }

    /**
     * 通过fieldName获取字段的get方法
     * @param obj
     * @param fieldName
     * @param parameterTypes
     * @return
     */
    public static Method getByFieldGetMethod(Object obj, String fieldName, Class<?>... parameterTypes) {
        if (StringUtils.isNotEmpty(fieldName)) {
            return getMethod(obj, StringUtils.getGetMethodByField(fieldName), parameterTypes);
        }
        return null;
    }

    /**
     * 通过fieldName获取字段的set方法
     * @param obj
     * @param fieldName
     * @param parameterTypes
     * @return
     */
    public static Method getByFieldSetMethod(Object obj, String fieldName, Class<?>... parameterTypes) {
        if (StringUtils.isNotEmpty(fieldName)) {
            return getMethod(obj, StringUtils.getSetMethodByField(fieldName), parameterTypes);
        }
        return null;
    }

    /**
     * 通过methodName获取方法
     * @param obj
     * @param methodName
     * @param parameterTypes
     * @return
     */
    public static Method getMethod(Object obj, String methodName, Class<?>... parameterTypes) {
        if (obj != null && StringUtils.isNotEmpty(methodName)) {
            try {
                return obj.getClass().getMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取当前对象方法的值
     * @param obj
     * @param fieldName
     * @param value
     * @param parameterTypes
     * @return
     */
    public static Object invokeGetMethod(Object obj, String fieldName, Object value, Class<?>... parameterTypes) {
        return invokeGetMethod(obj, fieldName, new Object[]{value}, parameterTypes);
    }

    /**
     * 获取当前对象方法的值
     * @param obj
     * @param fieldName
     * @param values
     * @param parameterTypes
     * @return
     */
    public static Object invokeGetMethod(Object obj, String fieldName, Object[] values, Class<?>... parameterTypes) {
        Method method = getByFieldGetMethod(obj, fieldName, parameterTypes);
        return invokeMethod(obj, method, values);
    }

    /**
     * 设置当前对象方法的值
     * @param obj
     * @param fieldName
     * @param value
     * @param parameterTypes
     * @return
     */
    public static Object invokeSetMethod(Object obj, String fieldName, Object value, Class<?>... parameterTypes) {
        return invokeSetMethod(obj, fieldName, new Object[]{value}, parameterTypes);
    }

    /**
     * 设置当前对象方法的值
     * @param obj
     * @param fieldName
     * @param values
     * @param parameterTypes
     * @return
     */
    public static Object invokeSetMethod(Object obj, String fieldName, Object[] values, Class<?>... parameterTypes) {
        Method method = getByFieldSetMethod(obj, fieldName, parameterTypes);
        return invokeMethod(obj, method, values);
    }

    /**
     * 调用方法返回对象
     * @param obj
     * @param method
     * @param values
     * @return
     */
    public static Object invokeMethod(Object obj, Method method, Object... values) {
        if (obj != null && method != null) {
            try {
                return method.invoke(obj, values);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取对象字段的值
     * @param obj
     * @param field
     * @param objects
     * @return
     */
    public static Object getValueByField(Object obj, Field field, Object... objects) {
        Method method = getByFieldGetMethod(obj, field);
        return invokeMethod(obj, method, objects);
    }

    /**
     * 设置对象字段的值
     * @param obj
     * @param field
     * @param objects
     * @return
     */
    public static Object setValueByField(Object obj, Field field, Object... objects) {
        Method method = getByFieldSetMethod(obj, field, field.getType());
        return invokeMethod(obj, method, objects);
    }

    /**
     * 如果字段是list，返回字段的泛型
     * @param field
     * @return
     */
    public static Class<?> getFieldGeneric(Field field) {
        if (field.getType() == List.class) {
            Type type = field.getGenericType();
            if (type != null && type instanceof ParameterizedType) {
                return getGeneric((ParameterizedType) type);
            }
        }
        return field.getType();
    }

    /**
     * 返回class的泛型
     * @param clazz
     * @return
     */
    public static Class<?> getFieldGeneric(Class<?> clazz) {
        if (clazz != null) {
            return getGeneric((ParameterizedType) clazz.getGenericSuperclass());
        }
        return clazz;
    }

    /**
     * 返回type的泛型
     * @param type
     * @return
     */
    public static Class<?> getGeneric(ParameterizedType type) {
        if (type != null) {
            Class<?> actClazz = (Class<?>) type.getActualTypeArguments()[0];
            return actClazz;
        }
        return null;
    }

    /**
     * 初始化class内的字段类型为list的class
     * @param clazz
     */
    public static List<Class<?>> initAllListType(Class<?> clazz) {
        List<Class<?>> clazzList = new ArrayList<>();
        initAllListType(clazzList, clazz);
        return clazzList;
    }

    /**
     * 初始化class内的字段类型为list的class
     * @param clazzList
     * @param clazz
     */
    public static void initAllListType(List<Class<?>> clazzList, Class<?> clazz) {
        if (clazzList != null && clazzList.size() == 0) {
            clazzList.add(clazz);
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == List.class) {
                Class<?> actClazz = getFieldGeneric(field);
                clazzList.add(actClazz);
                initAllListType(clazzList, actClazz);
            }
        }
    }

    /**
     * 设置字段类型为clazz的值为null
     * @param object
     * @param clazz
     */
    public static void setFieldValueByClass(Object object, Class<?> clazz) {
        setFieldValueByClass(object, null, clazz);
    }

    /**
     * 设置字段类型为clazz的值为value
     * @param object
     * @param value
     * @param clazz
     */
    public static void setFieldValueByClass(Object object, Object value, Class<?> clazz) {
        setFieldValueByClass(object, value, clazz, clazz.getSuperclass());
    }

    /**
     * 设置字段类型为clazz的值为value,只处理为object和list类型
     * @param object 对象
     * @param value 值
     * @param clazz 字段类和参数类相同
     * @param parentClazz 字段的类是该参数的子类
     */
    @SuppressWarnings("unchecked")
    public static void setFieldValueByClass(Object object, Object value, Class<?> clazz, Class<?> parentClazz) {
        if (object == null || clazz == null || parentClazz == null) {
            return;
        }
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if ("serialVersionUID".equals(field.getName()))	{
                continue;
            }

            if (List.class == field.getType()) {
                Class<?> fieldClazz = getFieldGeneric(field);
                if (clazz == fieldClazz) {
                    if (value != null) {
                        List<Object> list = (List<Object>) value;
                        if (list != null && list.size() > 0) {
                            Object listItem = list.get(0);
                            if (listItem != null && clazz == listItem.getClass()) {
                                setValueByField(object, field, value);
                            }
                        }
                    } else {
                        setValueByField(object, field, value);
                    }
                } else {
                    List<Object> objs = (List<Object>) getValueByField(object, field);
                    if (objs != null) {
                        for (Object obj : objs) {
                            setFieldValueByClass(obj, value, clazz, parentClazz);
                        }
                    }
                }
            } else if (clazz == field.getType()) {
                setValueByField(object, field, value);
            } else {
                if (field.getType().getSuperclass() == parentClazz) {
                    Object obj = getValueByField(object, field);
                    setFieldValueByClass(obj, value, clazz, parentClazz);
                }
            }
        }
    }

    /**
     * 获取class的字段缓存
     * @param clazz
     * @return
     */
    public static Map<String, Field> getClassFieldCache(Class<?> clazz) {
        Map<String, Field> map = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            map.put(field.getName(), field);
        }
        return map;
    }

}
