package com.egeo.gen.utils;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egeo.gen.model.GenEntity;
import com.egeo.gen.model.ProEntity;
import com.egeo.utils.date.DateUtils;

public class VelocityUtils {
	private static Logger logger = LoggerFactory.getLogger(VelocityUtils.class);

	public static String getString(String template, GenEntity entity) {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

		ve.init();
		Template actionTpt = ve.getTemplate(template, "UTF-8");
		VelocityContext ctx = new VelocityContext();
		ctx.put("className", entity.getClassName());
		ctx.put("name", entity.getName());
		ctx.put("comment", entity.getComment());
		ctx.put("fields", entity.getFields());
		ctx.put("ref", entity.getRef());
		ctx.put("module", entity.getModule());
		ctx.put("author", entity.getAuthor());
		ctx.put("packageName", entity.getPackageName());
		ctx.put("filePath", entity.getFilePath());
		ctx.put("today", DateUtils.getDefaultDateTimeNow());
		ctx.put("table", entity.getTable());
		ctx.put("pk", entity.getPk());
		ctx.put("findById", entity.getFindById());
		ctx.put("findOfPage", entity.getFindOfPage());
		ctx.put("findAll", entity.getFindAll());
		ctx.put("insert", entity.getInsert());
		ctx.put("update", entity.getUpdate());
		ctx.put("delete", entity.getDelete());
		StringWriter writer = new StringWriter();
		try {
			actionTpt.merge(ctx, writer);
			writer.flush();
			String str = writer.toString();
			return str;
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				logger.error("", e);
			}
		}
		return null;
	}

	public static String getString(String template, ProEntity entity) {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

		ve.init();
		Template actionTpt = ve.getTemplate(template, "UTF-8");
		VelocityContext ctx = new VelocityContext();
		ctx.put("projectName", entity.getProjectName());
		ctx.put("parentVersion", entity.getParentVersion());
		ctx.put("version", entity.getVersion());
		ctx.put("egeoUtilsVersion", entity.getEgeoUtilsVersion());
		ctx.put("egeoCoreVersion", entity.getEgeoCoreVersion());
		ctx.put("egeoDubboVersion", entity.getEgeoDubboVersion());
		ctx.put("filePath", entity.getFilePath());

		StringWriter writer = new StringWriter();
		try {
			actionTpt.merge(ctx, writer);
			writer.flush();
			String str = writer.toString();
			return str;
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				logger.error("", e);
			}
		}
		return null;
	}
}
