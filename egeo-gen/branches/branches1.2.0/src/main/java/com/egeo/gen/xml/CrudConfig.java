package com.egeo.gen.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "config")
public class CrudConfig {
	private String rootPath;
	private String author;
	private String module;
	private String prefix;
	private String tableSchema;
	private List<String> templates;
	private List<String> tables;
	private String  findById;
	private String  findOfPage;
	private String  findAll;
	private String  insert;
	private String  update;
	private String  delete;

	@XmlElement(name = "rootPath")
	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	@XmlElementWrapper(name = "templates")
	@XmlElement(name = "template")
	public List<String> getTemplates() {
		return templates;
	}

	public void setTemplates(List<String> templates) {
		this.templates = templates;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	@XmlElementWrapper(name = "tables")
	@XmlElement(name = "table")
	public List<String> getTables() {
		return tables;
	}

	public void setTables(List<String> tables) {
		this.tables = tables;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFindById() {
		return findById;
	}

	public void setFindById(String findById) {
		this.findById = findById;
	}

	public String getFindOfPage() {
		return findOfPage;
	}

	public void setFindOfPage(String findOfPage) {
		this.findOfPage = findOfPage;
	}

	public String getFindAll() {
		return findAll;
	}

	public void setFindAll(String findAll) {
		this.findAll = findAll;
	}

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}


	
	
}
