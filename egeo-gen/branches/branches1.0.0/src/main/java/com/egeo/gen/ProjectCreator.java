package com.egeo.gen;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.egeo.gen.model.ProEntity;
import com.egeo.gen.utils.VelocityUtils;
import com.egeo.gen.utils.XmlUtils;
import com.egeo.gen.xml.JaxbMapper;
import com.egeo.gen.xml.ProjectConfig;
import com.egeo.gen.xml.Template;
import com.egeo.utils.io.FileUtil;

/**
 * Hello world!
 *
 */
public class ProjectCreator {

	static Logger logger = LoggerFactory.getLogger(ProjectCreator.class);
	static ProjectConfig config = XmlUtils.fileToObject("projectConfig.xml", ProjectConfig.class);

	public static void main(String[] args) {
		
		ProEntity entity = new ProEntity(config);		
		List<String> list = config.getTemplates();
		for (String tpl : list) {
			String s = VelocityUtils.getString(tpl, entity);
			Template template = JaxbMapper.fromXml(s, Template.class);
			String filePath = template.getFilePath();
			String fileName = template.getFileName();
			fileName = config.getRootPath() + filePath + fileName;
			FileUtil fileUtil = FileUtil.getInstance(fileName);
			try {
				fileUtil.write(template.getContent());
			} catch (IOException e) {
				logger.error("", e);
			} finally {
				fileUtil.close();
			}
		}
	}

}
