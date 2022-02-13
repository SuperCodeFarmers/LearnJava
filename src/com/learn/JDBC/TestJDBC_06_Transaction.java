package com.learn.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

/*
 * 事物：
 * 
 * 需求：
 * 	删除某个订单：
 * 	（1）删除订单表的记录
 * 	（2）删除订单明细表的记录
 * 
 * 	如果在订单明细表建立外键时 指定 on delete cascade,那么在删除订单时，会自动把对应的订单明细表的记录删除。
 * 	如果没有建立外键，那么在删除订单时，不会自动将对应的订单明细表的记录删除。那么就需要程序员，再编写对应的SQL去删除订单明细表的记录
 * 
 * 	假设，现在要删除“111111”的订单
 * 
 * 
 * 如何处理事务？
 * （1）在获取完连接后，在使用这个连接来创建PreparedStatement对象之前，要设置当前连接为手动提交事务
 * 		connection.setAutoCommit(false);
 * （2）在执行成功时，应该提交：connection.commit();
 * 		在执行失败时或出现异常，应该回滚：connection.rollback();
 * （3）在关闭连接之前，把手动提交模式重新修改为自动提交模式
 * 		因为后面获取的连接基本上时从数据库连接池中获取的连接，这种连接时“重复”使用的，如果你把连接修改为“手动”提交了，
 * 		然后没有“还原”，当你把这个连接还给连接池时，这个连接可能会被其他人拿到，而他以为是自动提交的，然后操作完他的SQL后，没有commit，结果造成没有生效。
 * 		connection.setAutoCommit(true);
 * 
 */

public class TestJDBC_06_Transaction {

	/*
	 * 没有处理事物，MySQL时自动提交，执行成功一条，就commit一条，所以第二条失败后，第一条也commit了，无法撤销了。
	 */
	public void test01() throws ClassNotFoundException, SQLException {
		// 1、注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2、获取连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection connection = DriverManager.getConnection(url, "root", "yudongyang");

		// 3、编写SQL
		// 删除订单表
		String sql = "DELETE FROM orders WHERE id = ?";
		// 删除明细表
		String sql2 = "DELETE FROM orders_items WHERE order_id = ?"; // 故意把这条SQL写错，使得SQL2执行失败

		// 4、创建preparedStatement对象
		PreparedStatement pst1 = connection.prepareStatement(sql);
		pst1.setObject(1, "1111111");

		PreparedStatement pst2 = connection.prepareStatement(sql2);
		pst1.setObject(1, "1111111");

		int update = pst1.executeUpdate();
		System.out.println(update > 0 ? "删除订单成功" : "删除订单失败");

		int update2 = pst2.executeUpdate();
		System.out.println(update2 > 0 ? "删除订单明细表成功" : "删除订单明细表失败");

		pst1.close();
		pst2.close();
		connection.close();
	}

	/*
	 * 现在想要保证SQL1和SQL2构成一个事务，要么同时成功，要么同时失败。
	 */
	@Test
	public void test02() throws ClassNotFoundException, SQLException {
		// 1、注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2、获取连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection connection = DriverManager.getConnection(url, "root", "yudongyang");

		connection.setAutoCommit(false);

		// 3、编写SQL
		// 删除订单表
		String sql = "DELETE FROM orders WHERE id = ?";
		// 删除明细表
		String sql2 = "DELETE FROM orders_items WHERE order_id = ?"; // 故意把这条SQL写错，使得SQL2执行失败

		// 4、创建preparedStatement对象
		PreparedStatement pst1 = connection.prepareStatement(sql);
		pst1.setObject(1, "1111111");

		PreparedStatement pst2 = connection.prepareStatement(sql2);
		pst1.setObject(1, "1111111");

		try {

			int update = pst1.executeUpdate();
			System.out.println(update > 0 ? "删除订单成功" : "删除订单失败");

			int update2 = pst2.executeUpdate();
			System.out.println(update2 > 0 ? "删除订单明细表成功" : "删除订单明细表失败");

			if (update > 0 && update2 > 0) {
				// 两个SQL语句都成功才提交事务
				connection.commit();
			} else {
				// 只要有一个失败就回滚事务
				connection.rollback();
			}

		} catch (Exception e) {
			// 出现异常直接回滚事务
			connection.rollback();
		}

		pst1.close();
		pst2.close();
		connection.setAutoCommit(true); // 还原MySQL自动提交事务
		connection.close();
	}

}
