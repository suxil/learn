package com.learn.generator.utils;

import com.learn.core.utils.Dom4jXmlUtils;
import com.learn.core.utils.StringUtils;
import com.learn.generator.model.CompareResult;
import org.dom4j.Document;
import org.dom4j.Element;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ComparisonUtils {

	/**
	 * 比较两个xml文档结构是否一致
	 * @param sourceFile
	 * @param targetFile
	 * @return
	 */
	public static boolean xmlFileComparison(String sourceFile, String targetFile) {
		return xmlFileComparison(sourceFile, targetFile, false);
	}
	
	/**
	 * 比较两个xml文档结构是否一致
	 * @param sourceFile
	 * @param targetFile
	 * @param completely
	 * @return
	 */
	public static boolean xmlFileComparison(String sourceFile, String targetFile, boolean completely) {
		File sfile = new File(sourceFile);
		File tfile = new File(targetFile);
		if (sfile.getName().equals(tfile.getName())) {
			System.out.println("文件名相同");
			return false;
		}
		Document sourceDocument = Dom4jXmlUtils.readDocument(sourceFile);
		Document targetDocument = Dom4jXmlUtils.readDocument(targetFile);
		Element sourceElement = sourceDocument.getRootElement();
		Element targetElement = targetDocument.getRootElement();

		Map<String, Map<String, CompareResult>> map = new HashMap<>();
		
		compareElement(sfile.getName(), map, sourceElement, targetElement, completely);
		compareElement(tfile.getName(), map, targetElement, sourceElement, completely);
		if (map.size() > 0) {
			System.out.println("-------------------------- 文档不同节点输出 --------------------------");
			for (Entry<String, Map<String, CompareResult>> entry : map.entrySet()) {
				System.out.println("--------------------------------------------------------------------");
				System.out.println(entry.getKey() + ": " + entry.getValue().size());
				
				for (Entry<String, CompareResult> entryRes : entry.getValue().entrySet()) {
					CompareResult res = entryRes.getValue();
					System.out.println("----" + res.getName());
				}
			}
		}
		return true;
	}
	
	/**
	 * 遍历source比较文档element元素并将target中不存在的字段存到map集合中
	 * @param prefix
	 * @param map
	 * @param source
	 * @param target
	 */
	public static void compareElement(String prefix, Map<String, Map<String, CompareResult>> map, Element source, Element target) {
		 compareElement(prefix, map, source, target, false);
	}
	
	/**
	 * 遍历source比较文档element元素并将target中不存在的字段存到map集合中
	 * @param prefix
	 * @param map
	 * @param source
	 * @param target
	 * @param completely
	 */
	public static void compareElement(String prefix, Map<String, Map<String, CompareResult>> map, Element source, Element target, boolean completely) {
		Iterator<Element> it = source.elementIterator();
		while (it.hasNext()) {
			Element element = it.next();
			String name = element.getName();
			if (StringUtils.isNotEmpty(name)) {
				CompareResult compareRes = isExistVo(target, source.getName(), name);
				compareRes.setOldValue(element.getTextTrim());
				
				if (!compareRes.isExist()) {
					// 没找到对应的节点，将当前节点的父节点名和前缀作为key记录下面的子集
					String key = prefix + "---->" + compareRes.getParentName();
					putCompareRes(map, key, compareRes);
				}
				if (completely) {
					if (!compareRes.valid()) {
						// 两个节点的值不为空且不相同是，将当前节点的父节点名和前缀作为key记录下面的子集
						String key = prefix + "---->" + compareRes.getParentName();
						putCompareRes(map, key, compareRes);
					}
				}
				compareElement(prefix, map, element, target, completely);
			}
		}
	}
	
	/**
	 * 将节点放入map集合
	 * @param map
	 * @param key
	 * @param compareRes
	 */
	public static void putCompareRes(Map<String, Map<String, CompareResult>> map, String key, CompareResult compareRes) {
		// 当前节点名称作为子集的键，将节点vo添加到子集value
		if (map.containsKey(key)) {
			Map<String, CompareResult> mapRes = map.get(key);
			if (!mapRes.containsKey(compareRes.getName())) {
				mapRes.put(compareRes.getName(), compareRes);
			}
		} else {
			Map<String, CompareResult> mapRes = new HashMap<String, CompareResult>();
			mapRes.put(compareRes.getName(), compareRes);
			map.put(key, mapRes);
		}
	}
	
	/**
	 * 元素是否存在，存在的元素值
	 * @param root
	 * @param elementName
	 * @return
	 */
	public static CompareResult isExistVo(Element root, String parentName, String elementName) {
		// 初始化比较vo对象
		CompareResult compareRes = CompareResult.newInstance(false, "", "");
		compareRes.setParentName(parentName);
		compareRes.setName(elementName);
		
		// 遍历所有节点
		Iterator<Element> it = root.elementIterator();
		while (it.hasNext()) {
			Element element = it.next();
			String name = element.getName();
			if (StringUtils.isNotEmpty(name)) {
				// 父节点和当前节点名称相同时返回存在，否则返回false
				if (root.getName().equals(parentName) && name.equals(elementName)) {
					compareRes.setValue(root.getTextTrim());
					compareRes.setExist(true);
					break;
				} else {
					if (!compareRes.isExist()) {
						compareRes = isExistVo(element, parentName, elementName);
					} else {
						break;
					}
				}
			}
		}
		return compareRes;
	}
	
}
