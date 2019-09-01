package com.egeo.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JDBCManager
 * 
 * @author guannan.shang
 * @date 2014-12-25 17:06:01
 * @version 1.0
 */
public class JDBCManager {
	private Logger logger = LoggerFactory.getLogger(JDBCManager.class);

	private String server;
	private String user;
	private String password;
	private String dbname;
	private String url;

	public int MAX_NUM = 50;
	public LinkedList<Connection> busy;
	public LinkedList<Connection> free;

	public JDBCManager(String server, String user, String password, String dbname){
		this.server = server;
		this.user = user;
		this.password = password;
		this.dbname = dbname;
		init();
	}

	public synchronized Connection getConnection() {
		try {
			Connection conn = null;
			if (free.size() > 0)
				conn = free.getFirst();
			if (conn == null) {
				if (free.size() + busy.size() < 50) {
					conn = createConnection();
					busy.add(conn);
				} else {
					conn = waitConnection(0);
					if (conn == null)
						throw new CreateConnectException("最多同时使用" + MAX_NUM + "个JDBC连接");
				}
			} else {
				free.remove(conn);
				busy.add(conn);
			}
			return conn;
		} catch (Exception e) {
			throw new CreateConnectException(e);
		}
	}

	public Connection waitConnection(int cnt) throws InterruptedException {
		if (cnt == 10)
			return null;
		Thread.sleep(5000);
		Connection conn = free.getFirst();
		if (conn != null)
			return conn;
		return waitConnection(cnt + 1);
	}

	public synchronized void release(Connection connection) {
		busy.remove(connection);
		free.add(connection);
	}

	/**
	 * 关闭所有连接
	 */
	public void close() {
		for (Connection connection : busy) {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("", e);
			}
		}
		for (Connection connection : free) {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("", e);
			}
		}
		busy.clear();
		free.clear();
	}

	public Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url);
	}

	public void init() {
		busy = new LinkedList<Connection>();
		free = new LinkedList<Connection>();
		try {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						logger.debug("**********************");
						logger.debug("空闲连接" + free.size());
						logger.debug("使用连接" + busy.size());
						try {
							Thread.sleep(5000);
						} catch (Exception e) {
						}
					}
				}
			});
		} catch (Exception e) {
		}
		String format = "jdbc:mysql://%s/%s?user=%s&password=%s&useUnicode=true&characterEncoding=UTF8";
		url = String.format(format, server, dbname, user, password);
	}
}
