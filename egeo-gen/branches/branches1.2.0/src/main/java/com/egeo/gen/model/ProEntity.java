package com.egeo.gen.model;

import com.egeo.gen.xml.ProjectConfig;
import com.egeo.utils.str.StringUtils;

public class ProEntity {
//	private String name;
	private String author;
	private String projectName;
	private String packageName;
	private String parentVersion;
	private String version;
	private String egeoUtilsVersion;
	private String egeoCoreVersion;
	private String egeoDubboVersion;
	
	public ProEntity(ProjectConfig config) {
		
		this.setAuthor(config.getAuthor());
		this.setProjectName(config.getProjectName());
		this.setParentVersion(config.getParentVersion());
		this.setVersion(config.getVersion());
		this.setEgeoCoreVersion(config.getEgeoCoreVersion());
		this.setEgeoDubboVersion(config.getEgeoDubboVersion());
		this.setEgeoUtilsVersion(config.getEgeoUtilsVersion());	
		this.setPackageName(config.getPackageName());
		
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


}
