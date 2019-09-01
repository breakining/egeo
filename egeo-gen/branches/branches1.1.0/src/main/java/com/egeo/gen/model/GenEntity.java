package com.egeo.gen.model;

import java.util.List;
import java.util.Set;

import com.egeo.utils.str.StringUtils;

public class GenEntity {
	private String name;
	private String author;
	private String packageName;
	private String module;
	private String comment;
	private List<GenProperty> fields;
	private Set<String> ref;
	private GenTable table;
	private GenProperty pk;

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

	public Set<String> getRef() {
		return ref;
	}

	public void setRef(Set<String> ref) {
		this.ref = ref;
	}

	public String getClassName() {
		return StringUtils.firstCharUpperCase(name);
	}

	public List<GenProperty> getFields() {
		return fields;
	}

	public void setFields(List<GenProperty> fields) {
		this.fields = fields;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getFilePath() {
		if (packageName == null)
			return null;
		return packageName.replace(".", "/");
	}

	public GenTable getTable() {
		return table;
	}

	public void setTable(GenTable table) {
		this.table = table;
	}

	public GenProperty getPk() {
		return pk;
	}

	public void setPk(GenProperty pk) {
		this.pk = pk;
	}
}
