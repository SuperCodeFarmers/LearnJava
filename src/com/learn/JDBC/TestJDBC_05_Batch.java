package com.learn.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

/*
 * 批处理：
 * 	当腰执行某条SQL语句很多次
 * 例如：
 * （1）批量添加测试数据
 * （2）当用户购买了东西后，一个订单中有很多的商品，那么就会涉及到
 * 1.在订单明细表中意味着要批量插入多条记录
 * 2.批量修改商品表的销量和库存两
 * ......
 * 
 * 如何实现批处理呢？
 * （1）执行时，不能直接调用prepareStatement.executeUpdate();这是一条一条语句进行执行
 * 那么需要这么做：
 * 1.prepareStatement.addBatch(); // 添加到批处理组中，先存着，本质上（底层）有一个缓冲区，先缓存所有要执行的SQL
 * 2.int[] batch = prepareStatement.executeBatch(); // 如果需要返回结果，就接收，不需要可以不接收
 * 
 * 
 * （2）
 * MySQL服务器默认是关闭批处理的，我们需要通过一个参数，让MySQL开启批处理
 * 在url后面加一个 rewriteBatchedStatements=true
 * url = "jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true";
 * 
 * （3）用批处理添加时，使用values，不要用value。
 * 
 * 
 * 
 * 例如：
 * 在test数据库的t_stu中添加10000条模拟数据
 * 	id:测试数据i i对应1---10000
 * 	name:测试数据i i对应1----10000
 * 
 * 
 */

public class TestJDBC_05_Batch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		long begin = System.currentTimeMillis();

		// 1、注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2、获取连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection connection = DriverManager.getConnection(url, "root", "yudongyang");

		// 3、编写SQL
		String sql = "INSERT INTO t_stu (id, name) VALUES (?, ?)"; // 不要用value，使用values

		// 4、创建preparedStatement对象
		PreparedStatement prepareStatement = connection.prepareStatement(sql);

		// 5、设置?的值
		for (int i = 1; i <= 1000; i++) {
			prepareStatement.setInt(1, i);
			prepareStatement.setString(2, "TestName:" + i);

			// 不用批处理，设置一次?，就执行一次
			prepareStatement.executeUpdate();
		}

		prepareStatement.close();
		connection.close();

		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin));
	}

	@Test
	private void test02() throws ClassNotFoundException, SQLException {

		long begin = System.currentTimeMillis();

		// 1、注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2、获取连接
		String url = "jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true";
		Connection connection = DriverManager.getConnection(url, "root", "yudongyang");

		// 3、编写SQL
		String sql = "INSERT INTO t_stu (id, name) VALUES (?, ?)";

		// 4、创建preparedStatement对象
		PreparedStatement prepareStatement = connection.prepareStatement(sql);

		// 5、设置?的值
		for (int i = 1; i <= 1000; i++) {
			prepareStatement.setInt(1, i);
			prepareStatement.setString(2, "TestName:" + i);

			// 不用批处理，设置一次?，就执行一次
//			prepareStatement.executeUpdate();
			
			prepareStatement.addBatch(); // 添加到批处理组中，先存着，本质上（底层）有一个缓冲区，先缓存所有要执行的SQL
		}

		// 循环外面,执行这组批处理
		int[] batch = prepareStatement.executeBatch(); // 如果需要返回结果，就接收，不需要可以不接收
		
		prepareStatement.close();
		connection.close();

		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin));
	}

}
