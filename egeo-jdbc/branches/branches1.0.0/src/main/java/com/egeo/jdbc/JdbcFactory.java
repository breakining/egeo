package com.egeo.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egeo.jdbc.conn.JDBCManager;

public class JdbcFactory {
	private static Logger logger = LoggerFactory.getLogger(JdbcFactory.class);
	private static Map<String, Jdbc> jdbcMap = new HashMap<String, Jdbc>();;
	private static Lock lock = new ReentrantLock();

	public static Jdbc getJdbc(String key) {
		String file = key + ".properties";
		if (jdbcMap.get(key) != null)
			return jdbcMap.get(key);
		lock.lock();
		if (jdbcMap.get(key) != null) {
			lock.unlock();
			return jdbcMap.get(key);
		}
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			inputStream = loader.getResourceAsStream(file);
			if (inputStream == null) {
				throw new IllegalArgumentException("Properties file not found: " + file);
			}
			properties.load(inputStream);
			if (!properties.containsKey("server"))
				throw new IllegalArgumentException("server is null in " + file);
			if (!properties.containsKey("user"))
				throw new IllegalArgumentException("user is null in " + file);
			if (!properties.containsKey("password"))
				throw new IllegalArgumentException("password is null in " + file);
			if (!properties.containsKey("dbname"))
				throw new IllegalArgumentException("dbname is null in " + file);

			String server = properties.getProperty("server");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			String dbname = properties.getProperty("dbname");
			JDBCManager jdbcManager = new JDBCManager(server, user, password, dbname);
			Jdbc jdbc = new Jdbc(jdbcManager);
			jdbcMap.put(key, jdbc);
			return jdbc;
		} catch (IOException e) {
			throw new IllegalArgumentException("Properties file can not be loading: " + file);
		} finally {
			lock.unlock();
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}
}
