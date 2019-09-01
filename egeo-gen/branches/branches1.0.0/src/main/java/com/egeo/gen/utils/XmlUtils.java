package com.egeo.gen.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egeo.gen.xml.JaxbMapper;

public class XmlUtils {
	static Logger logger = LoggerFactory.getLogger(XmlUtils.class);

	@SuppressWarnings("unchecked")
	public static <T> T fileToObject(String fileName, Class<?> clazz) {
		try {
			InputStream is = null;
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			is = loader.getResourceAsStream(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuilder sb = new StringBuilder();
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				sb.append(line).append("\r\n");
			}
			if (is != null) {
				is.close();
			}
			if (br != null) {
				br.close();
			}
			return (T) JaxbMapper.fromXml(sb.toString(), clazz);
		} catch (IOException e) {
			logger.warn("Error file convert: {}", e.getMessage());
		}
		return null;
	}
}
