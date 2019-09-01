package com.egeo.basics.read;

import java.io.File;

import com.alibaba.dubbo.container.Main;

public class DubboProvider {
	public static void main(String[] args) {
		String log4j = getFilePath("log4j.properties");
		// 设置log4j debug开关
		// 可以在启动参数中添加-Dlog4j.debug=true
		// System.setProperty("log4j.debug", "true");
		// 指定spring配置文件
		System.setProperty("dubbo.spring.config", "classpath*:spring-service.xml");
		// 指定log4j配置文件
		System.setProperty("log4j.configuration", "file:" + log4j);
		Main.main(null);
	}

	private static String getFilePath(String file) {
		String path = System.getProperty("global.config.path");
		if (path == null)
			return null;
		if (path.endsWith("/") || path.endsWith("\\"))
			path = path.substring(0, path.length() - 1);
		StringBuilder s = new StringBuilder();
		s.append(path);
		s.append(File.separator);
		s.append("basics-welfare").append(File.separator).append("basics-welfare-service").append(File.separator);
		return s.append(file).toString();
	}
}

	