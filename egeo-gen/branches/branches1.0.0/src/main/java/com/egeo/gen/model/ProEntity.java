package com.egeo.gen.model;

import com.egeo.gen.xml.ProjectConfig;
import com.egeo.utils.str.StringUtils;

public class ProEntity {
//	private String name;
	private String author;
	private String projectName;
	private String parentVersion;
	private String version;
	private String zgxcwUtilsVersion;
	private String zgxcwCoreVersion;
	private String zgxcwDubboVersion;
	
	public ProEntity(ProjectConfig config) {
		// TODO Auto-generated constructor stub
		
		this.setAuthor(config.getAuthor());
		this.setProjectName(config.getProjectName());
		this.setParentVersion(config.getParentVersion());
		this.setVersion(config.getVersion());
		this.setZgxcwCoreVersion(config.getZgxcwCoreVersion());
		this.setZgxcwDubboVersion(config.getZgxcwDubboVersion());
		this.setZgxcwUtilsVersion(config.getZgxcwUtilsVersion());
		
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getZgxcwUtilsVersion() {
		return zgxcwUtilsVersion;
	}
	public void setZgxcwUtilsVersion(String zgxcwUtilsVersion) {
		this.zgxcwUtilsVersion = zgxcwUtilsVersion;
	}
	public String getZgxcwCoreVersion() {
		return zgxcwCoreVersion;
	}
	public void setZgxcwCoreVersion(String zgxcwCoreVersion) {
		this.zgxcwCoreVersion = zgxcwCoreVersion;
	}
	public String getZgxcwDubboVersion() {
		return zgxcwDubboVersion;
	}
	public void setZgxcwDubboVersion(String zgxcwDubboVersion) {
		this.zgxcwDubboVersion = zgxcwDubboVersion;
	}

	public String getParentVersion() {
		return parentVersion;
	}

	public void setParentVersion(String parentVersion) {
		this.parentVersion = parentVersion;
	}






}
