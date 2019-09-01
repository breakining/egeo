package com.egeo.gen.model;

import com.egeo.utils.str.StringUtils;

public class GenProperty {
	/**
	 * 
	 */
	private Class<?> javaType;
	private String name;
	private String comment;
	private GenColumn column;

	public Class<?> getJavaType() {
		return javaType;
	}

	public void setJavaType(Class<?> javaType) {
		this.javaType = javaType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getJavaTypeName() {
		return javaType.getSimpleName();
	}

	public String getGetter() {
		return "get" + StringUtils.firstCharUpperCase(name);
	}

	public String getSetter() {
		return "set" + StringUtils.firstCharUpperCase(name);
	}

	public GenColumn getColumn() {
		return column;
	}

	public void setColumn(GenColumn column) {
		this.column = column;
	}
}
