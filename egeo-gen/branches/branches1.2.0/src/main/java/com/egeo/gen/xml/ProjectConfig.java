package com.egeo.gen.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "config")
public class ProjectConfig {
	private String rootPath;
	private String author;
	private List<String> templates;
	private String projectName;
	private String packageName;
	private String parentVersion;
	private String version;
	private String egeoUtilsVersion;
	private String egeoCoreVersion;
	private String egeoDubboVersion;


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

	public String getParentVersion() {
		return parentVersion;
	}

	public void setParentVersion(String parentVersion) {
		this.parentVersion = parentVersion;
	}

	public String getEgeoUtilsVersion() {
		return egeoUtilsVersion;
	}

	public void setEgeoUtilsVersion(String egeoUtilsVersion) {
		this.egeoUtilsVersion = egeoUtilsVersion;
	}

	public String getEgeoCoreVersion() {
		return egeoCoreVersion;
	}

	public void setEgeoCoreVersion(String egeoCoreVersion) {
		this.egeoCoreVersion = egeoCoreVersion;
	}

	public String getEgeoDubboVersion() {
		return egeoDubboVersion;
	}

	public void setEgeoDubboVersion(String egeoDubboVersion) {
		this.egeoDubboVersion = egeoDubboVersion;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}



}
