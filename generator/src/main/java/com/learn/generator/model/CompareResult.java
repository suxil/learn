package com.learn.generator.model;

import com.learn.core.utils.StringUtils;

/**
 * 文档比对临时对象
 *
 */
public class CompareResult {

	private CompareResult() {
	}

	private CompareResult(boolean isExist, String value, String oldValue) {
		super();
		this.isExist = isExist;
		this.value = value;
		this.oldValue = oldValue;
	}

	public static CompareResult newInstance(boolean isExist, String value, String oldValue) {
		CompareResult compareRes = new CompareResult(isExist, value, oldValue);
		return compareRes;
	}
	
	public boolean valid() {
		if (StringUtils.isNotEmpty(value) && StringUtils.isNotEmpty(oldValue)) {
			if (!value.equals(oldValue)) {
				return false; 
			}
		}
		return true;
	}

	private boolean isExist;
	private String parentName;
	private String name;
	private String value;
	private String oldValue;

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

}
