package com.egeo.utils.excel;

import java.util.Map;

public class ExcelCell {

	private String key;
	private Map<String, Object> dictMap;
	private String condition;

	public ExcelCell() {
	}

	public ExcelCell(String key) {
		this.key = key;
	}

	public Map<String, Object> getDictMap() {
		return dictMap;
	}

	public void setDictMap(Map<String, Object> dictMap) {
		this.dictMap = dictMap;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
}
