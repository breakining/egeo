package com.egeo.gen.utils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egeo.gen.model.GenColumn;
import com.egeo.gen.model.GenEntity;
import com.egeo.gen.model.GenProperty;
import com.egeo.gen.model.GenTable;
import com.egeo.jdbc.Jdbc;
import com.egeo.jdbc.JdbcFactory;
import com.egeo.utils.str.StringUtils;

public class GenUtils {
	private static Logger logger = LoggerFactory.getLogger(GenUtils.class);
	private static final String TABLE_SQL = "select table_schema,table_name,table_comment from tables where table_schema = ? and table_name = ?";
	private static final String COLUMN_SQL = "select column_key,extra,table_schema,table_name,column_name,data_type,column_comment from columns where table_schema = ? and table_name = ?";
	private static final String TABLES_SQL = "select table_name from tables where table_schema = ?";
	private static Jdbc jdbc = JdbcFactory.getJdbc("jdbc");

	public static List<String> getTableList(String tableSchema) {
		try {
			List<String> tables = jdbc.query(String.class, TABLES_SQL, tableSchema);
			return tables;
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	public static GenEntity getEntity(String tableSchema, String tableName) {
		try {
			GenTable table = jdbc.queryOne(GenTable.class, TABLE_SQL, tableSchema, tableName);
			List<GenColumn> list = jdbc.query(GenColumn.class, COLUMN_SQL, tableSchema, tableName);
			if (table == null)
				return null;
			GenEntity entity = new GenEntity();
			List<GenProperty> fields = new ArrayList<GenProperty>();
			Set<String> ref = new HashSet<String>();

			for (GenColumn column : list) {
				GenProperty property = new GenProperty();
				Class<?> clazz = TypeUtils.getJavaType(column.getDataType());
				if (clazz.equals(Date.class) || clazz.equals(BigDecimal.class))
					ref.add(clazz.getName());

				property.setName(StringUtils.parse2Camel(column.getColumnName()));
				property.setComment(column.getColumnComment());
				property.setJavaType(clazz);
				property.setColumn(column);
				if ("PRI".equals(column.getColumnKey()))
					entity.setPk(property);
				else
					fields.add(property);
			}
			entity.setTable(table);
			entity.setName(StringUtils.parse2Camel(tableName));
			entity.setComment(table.getTableComment());
			entity.setFields(fields);
			entity.setRef(ref);
			return entity;
		} catch (SQLException e) {
			logger.error("", e);
		}
		return null;
	}
}
