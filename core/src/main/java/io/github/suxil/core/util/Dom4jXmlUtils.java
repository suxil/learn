package io.github.suxil.core.util;

import io.github.suxil.core.util.anotation.CDATAType;
import io.github.suxil.core.util.anotation.IgnoreElement;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

@Slf4j
public final class Dom4jXmlUtils {

    private static final String ELM_PRIFIX = "";// 命名空间别名
    private static final String MH = ":";
    private static final String REMOVE_FIELD_PREFIX = "List";// 移除空字段后缀

    private static final String ROOT_NAME = "root"; // 根元素名称
    private static final String ELM_ALIAS = "custxml"; // 命名空间别名

    public static final String ALL_PREFIX = ELM_PRIFIX + MH;// 命名空间前缀
    public static final String ALL_URI = "";// 命名空间uri

    private Dom4jXmlUtils() {
    }

    /**
     * 通过class获取qname
     * @param clazz
     * @return
     */
    public static QName getQName(Class<? extends Object> clazz) {
        return getQName(clazz.getSimpleName());
    }

    /**
     * 通过field获取qname
     * @param field
     * @return
     */
    public static QName getQName(Field field) {
        return getQName(field.getName());
    }

    /**
     * 获取默认qname
     * @param fieldName 字段名称
     * @return
     */
    public static QName getQName(String fieldName) {
        fieldName = StringUtils.getFieldToColumn(fieldName);
        return getQName(fieldName, ELM_PRIFIX, ALL_URI, ALL_PREFIX + fieldName);
    }

    /**
     * 获取qname
     * @param name 字段名称
     * @param nsPrefix 命名空间前缀
     * @param nsUri 命名空间 uri
     * @param qualifiedName 别名->转换为节点名
     * @return
     */
    public static QName getQName(String name, String nsPrefix, String nsUri, String qualifiedName) {
        return new QName(name, new Namespace(nsPrefix, nsUri), qualifiedName);
    }

    /**
     * xml生成回调接口
     */
    public interface DocumentCallback {
        void doInDocument(Element root);
    }

    /**
     * 模板方法提供基础dom根元素
     * @param qName
     * @param action
     * @return
     */
    public static Document executer(QName qName, DocumentCallback action) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement(ROOT_NAME);
        if (qName != null) {
            root.setQName(qName);
        }
        if (action != null) {
            action.doInDocument(root);
        }
        return document;
    }

    /**
     * 通过object集合返回doc对象
     * @param obj
     * @return
     */
    public static Document getXmlDocument(Object obj) {
        return  getXmlDocument(obj, null);
    }

    /**
     * 通过object集合返回doc对象
     * @param obj
     * @param filter
     * @return
     */
    public static Document getXmlDocument(Object obj, Collection<Class<?>> filter) {
        return  getXmlDocument(getQName(ELM_ALIAS), obj, filter);
    }

    /**
     * 自定义命名空间，通过object集合返回doc对象
     * @param qName
     * @param obj
     * @return
     */
    public static Document getXmlDocument(QName qName, Object obj) {
        return getXmlDocument(qName, obj, null);
    }

    /**
     * 自定义命名空间，通过object集合返回doc对象
     * @param qName
     * @param obj
     * @param filter
     * @return
     */
    public static Document getXmlDocument(QName qName, Object obj, Collection<Class<?>> filter) {
        return executer(qName, root -> addElement(root, obj, filter));
    }

    /**
     * 通过object集合返回xml字符串
     * @param obj
     * @return
     */
    public static String getXmlString(Object obj) {
        return  getXmlString(obj, null);
    }

    /**
     * 通过object集合返回xml字符串
     * @param obj
     * @param filter
     * @return
     */
    public static String getXmlString(Object obj, Collection<Class<?>> filter) {
        return  getXmlDocument(obj, filter).asXML();
    }

    /**
     * 自定义命名空间，通过object集合返回xml字符串
     * @param qName
     * @param obj
     * @return
     */
    public static String getXmlString(QName qName, Object obj) {
        return  getXmlString(qName, obj, null);
    }

    /**
     * 自定义命名空间，通过object集合返回xml字符串
     * @param qName
     * @param obj
     * @param filter
     * @return
     */
    public static String getXmlString(QName qName, Object obj, Collection<Class<?>> filter) {
        return  getXmlDocument(qName, obj, filter).asXML();
    }

    /**
     * 处理list类型dom元素
     * @param parentElement
     * @param list
     * @param filter
     */
    @SuppressWarnings("unchecked")
    public static void operListElement(Element parentElement, List<Object> list, Collection<Class<?>> filter) {
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                if (obj instanceof List) {
                    operListElement(parentElement, (List<Object>) obj, filter);
                } else {
                    addElement(parentElement, obj, filter);
                }
            }
        }
    }

    /**
     * 将一个对象的所有字段解析为下划线形势，添加为xml dom元素
     * @param element
     * @param obj
     * @param filter
     */
    @SuppressWarnings("unchecked")
    public static void addElement(Element element, Object obj, Collection<Class<?>> filter) {
        if (obj == null) {
            return;
        }
        if (obj instanceof List) {
            operListElement(element, (List<Object>) obj, filter);
            return;
        }
        Class<?> clazz = obj.getClass();
        if (filter != null && filter.contains(clazz)) {
            return;
        }
        IgnoreElement ignoreElement = clazz.getAnnotation(IgnoreElement.class);
        if (ignoreElement == null) {
            element = element.addElement(getQName(obj.getClass()));
        }
        addObj(element, obj, filter);
    }

    /**
     * 添加对象属性到element
     * @param element
     * @param obj
     * @param filter
     */
    public static void addObj(Element element, Object obj, Collection<Class<?>> filter) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }
            Class<?> fieldClazz = ReflectUtils.getFieldGeneric(field);
            if (filter != null && filter.contains(fieldClazz)) {
                continue;
            }

            addField(element, obj, field, filter);
        }
    }

    /**
     * 添加字段到element
     * @param element
     * @param obj
     * @param field
     * @param filter
     */
    @SuppressWarnings("unchecked")
    public static void addField(Element element, Object obj, Field field, Collection<Class<?>> filter) {
        Object valObj = ReflectUtils.getValueByField(obj, field);
        if (valObj instanceof List) {
            operListElement(element, (List<Object>) valObj, filter);
        } else {
            if (isRecursion(valObj)) {
                addElement(element, valObj, filter);
            } else {
                // 对于对象类型且不为空的处理
                getFieldAttr(element, field, valObj);
            }
        }
    }

    /**
     * 添加是否递归自身，默认非字符串（字段为字符串和实体两种类型，其他类型自行修改）
     * @param obj
     * @return
     */
    public static boolean isRecursion(Object obj) {
        if (obj != null && !(obj instanceof String)) {
            return true;
        }
        return false;
    }

    /**
     * 根据field的CDATAType注解，判断是否CDATA类型
     * @param field
     * @param val
     */
    public static void getFieldAttr(Element element, Field field, Object val) {
        IgnoreElement ignoreElement = field.getAnnotation(IgnoreElement.class);
        if (ignoreElement != null) {
            return;
        }
        if (val != null) {
            Element elmAttr = element.addElement(getQName(field));
            CDATAType cdataType = field.getAnnotation(CDATAType.class);
            if (cdataType != null) {
                elmAttr.addCDATA(String.valueOf(val));
            } else {
                elmAttr.addText(String.valueOf(val));
            }
        } else {
            // 如果val为空，移除字段末尾的List字符串
            element.addElement(getQName(StringUtils.removeLastPrefix(field.getName(), REMOVE_FIELD_PREFIX)));
        }
    }

    /**
     * 获取默认输出格式化样式
     */
    public static OutputFormat getDefaultOutputFormat(boolean isExpandEmptyElements) {
        //设置文件编码
        OutputFormat xmlFormat = new OutputFormat();
        xmlFormat.setEncoding("UTF-8");
        // 设置换行
        xmlFormat.setNewlines(true);
        // 生成缩进
        xmlFormat.setIndent(true);
        // 使用4个空格进行缩进, 可以兼容文本编辑器
        xmlFormat.setIndent("    ");
        // 关闭自闭合
        xmlFormat.setExpandEmptyElements(isExpandEmptyElements);
        return xmlFormat;
    }

    /**
     * 字符串转换为document对象
     * @param content
     * @return
     */
    public static Document stringToDocument(String content) {
        try {
            return DocumentHelper.parseText(content);
        } catch (DocumentException e) {
            log.error("stringToDocument: " + e.getMessage());
        }
        return null;
    }

    /**
     * 通过路径读取xml字符串
     * @param path
     * @return
     */
    public static String readString(String path) {
        String content = FileIOUtils.read(path);
        return content;
    }

    /**
     * 读取xml文件并转换为document对象
     * @param path
     * @return
     */
    public static Document readDocument(String path) {
        String content = readString(path);
        return stringToDocument(content);
    }

    /**
     * 通过路径转换为document对象
     * @param path
     * @return
     */
    public static Document read(String path) {
        try {
            SAXReader reader = new SAXReader();
            reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            return reader.read(new File(path));
        } catch (DocumentException e) {
            log.error("read DocumentException: " + e.getMessage());
        } catch (SAXException e) {
            log.error("read SAXException: " + e.getMessage());
        }
        return null;
    }

}
