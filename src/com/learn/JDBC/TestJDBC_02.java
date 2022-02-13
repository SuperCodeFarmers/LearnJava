package com.learn.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

/*
 * Statement：声明，报告；说明，说法，表态；结算单，报表
 * 
 * 步骤：
 * 1、注册驱动
 * 三部曲：（1）把jar包复制到libs中.（2）把jar添加到Build Path中（3）加载驱动类
 * 
 * 2、建立连接
 * 	获取Connection对象
 * 
 * 3、执行SQL
 * （1）编写SQL
 * （2）创建Statement
 * （3）执行SQL
 * 
 * 增删改：int len = Statement对象.executeUpdate(sql);
 * 查：ResultSet rs = Statement对象.executeQuery(sql);
 * 
 * 4、遍历结果集
 * 
 * 5、关闭资源
 */

public class TestJDBC_02 {

	@Test
	public void test01() throws ClassNotFoundException, SQLException {
		// 1、加载驱动类
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2、连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection connection = DriverManager.getConnection(url, "root", "yudongyang");

		// 3、执行SQL
		String sql = "SELECT id, name FROM t_stu";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		// 4、遍历结果集
		/*
		 * resultSet.next():还有没有下一行。
		 * resultSet.getXXX(字段名)
		 */
		while (resultSet.next()) {
			int i = resultSet.getInt("id");
			String name = resultSet.getString("name");
			System.out.println("id:" + i + ", name:" + name);
		}

		statement.close();
		connection.close();
	}

	
	
}
