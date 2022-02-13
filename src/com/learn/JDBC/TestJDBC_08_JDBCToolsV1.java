package com.learn.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * 这个版本只能用于不需要处理事务的情况
 * 
 */


public class TestJDBC_08_JDBCToolsV1 {

	private static DataSource dataSource;

	// 静态代码块初始化静态变量
	static {
		Properties properties = new Properties();
		try {
			properties.load(TestJDBC_08_JDBCToolsV1.class.getClassLoader().getResourceAsStream("Durid.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		// 方式一：DriverManager.getConnection()
		// 方式二：连接池对象.getConnection()

		return dataSource.getConnection();
	}
	
	// 把编译时异常转成运行时异常
	public static void free(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// e.printStackTrace();
				// 把异常转成运行时异常
				throw new RuntimeException(e);
			}
		}
	}
	
	
	// 这个方法只能用于不需要处理事务的情况
	// 增加、修改、删除
	public static int update(String sql, Object... args) throws SQLException {
		// 获取连接
		Connection connection = dataSource.getConnection();
		
		// 创建preparedStatement
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
	
		// 设置?数据
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				prepareStatement.setObject(i+1, args[i]);
			}
		}
		
		// 执行sql
		int update = prepareStatement.executeUpdate();
		
		prepareStatement.close();
		free(connection);
		
		return update;
	}

}
