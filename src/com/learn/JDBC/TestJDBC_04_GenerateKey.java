package com.learn.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * 在使用PreparedStatement添加数据时，获取自增长的键值
 * 例如：
 * 	购物时，结算时，会产生新订单，会返回新的订单，而一般订单编号都是自增长或随机生成的，保证这个订单编号的唯一。
 * 
 * 
 * 举例：
 * 	在添加一个部门后，立刻返回这个部门的新的编号，而这个编号是自增长
 * 
 * 如何让PreparedStatement执行完insert的sql后，带回自增长的键值？
 * （1）在创建这个PreparedStatement对象时，就要执行需要返回自增长键值，否则MySQL不会返回
 * （2）通过拿到结果集来获取自增长键值
 * 但是方法不要调用getResultSet()来获取结果集，而是通过getGenerateKeys()来获取结果集
 * ResultSet resultSet = prepareStatement.getGeneratedKeys();
 * 
 * 
 */

public class TestJDBC_04_GenerateKey {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1、注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2、获取连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection connection = DriverManager.getConnection(url, "root", "yudongyang ");
		
		// 3、编写SQL
		String sql = "INSERT INTO t_department VALUES(NULL, ?, ?)";
		
		// 4、创建PreparedStatement
		// 在Statement这个接口中，声明了几个常量，其中一个是Statement.RETURN_GENERATED_KEYS，表示返回自增长的键值
		PreparedStatement prepareStatement = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
		
		// 5、设置?的值
		prepareStatement.setObject(1, "发钱部门");
		prepareStatement.setObject(2, "xxxx");
		
		// 6、执行SQL
		int update = prepareStatement.executeUpdate();
		System.out.println(update > 0 ? "添加成功" : "添加失败");
		
		// 7、获取自增长键值
		ResultSet resultSet = prepareStatement.getGeneratedKeys(); // MySQL服务器通过结果集把自增长的键值返回回来
		
		
		resultSet.close();
		prepareStatement.close();
		connection.close();
		
		
	}

}
