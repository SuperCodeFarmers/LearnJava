package com.learn.JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.jupiter.api.Test;


/*
 * Statement问题：
 * 1、SQL拼接太麻烦
 * 2、容易SQL注入
 * 3、无法处理blob等二进制类型的数据
 * 
 * 如何解决这些问题，使用Statement的子接口PreparedStatement
 */

public class TestJDBC_03_StatementProblem {
	
	// 无法处理二进制问题
	@Test
	public void test01() throws ClassNotFoundException, SQLException {

		// 1、加载驱动类
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2、连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection connection = DriverManager.getConnection(url, "root", "yudongyang");

		/*
		 * 
		 * 
		 * +----------+--------------+------+-----+---------+-------+ 
		 * | Field    | Type         | Null | Key | Default | Extra |
		 * +----------+--------------+------+-----+---------+-------+ 
		 * | username | varchar(100) | NO   |     | NULL    |       | 
		 * | password | varchar(100) | NO   |     | NULL    |       | 
		 * | photo    | blob         | YES  |     | NULL    |       | 
		 * | id       | int          | NO   | PRI | NULL    |       |
		 * +----------+--------------+------+-----+---------+-------+ 
		 * 4 rows in set (0.00 sec)
		 * 
		 */

		// 3、执行SQL
		String sql = "INSERT INTO test.t_user (username, password, photo, id) VALUES('', '', ?, 0)"; // 无法处理blob
		Statement statement = connection.createStatement();
		int update = statement.executeUpdate(sql);

		statement.close();
		connection.close();
		
	}
	
	
	// SQL注入问题
	@Test
	public void test02() throws ClassNotFoundException, SQLException {
		// 员工自己查询自己的信息：从键盘输入员工的新能，查询自己的信息
		
		// 1、加载驱动类
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2、获取连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection connection = DriverManager.getConnection(url, "root", "yudongayng");
		
		
		// 员工输入
		Scanner input = new Scanner(System.in);
		System.out.println("输入员工名字:");
		String name = input.nextLine(); // 输入：孙红雷' or '1'='1
		
		// 3、编写SQL
		String sql = "SELECT * FROM t_employee WHERE name = '" + name  +"'";
		// "SELECT * FROM t_employee WHERE name = '孙红雷' or '1'='1'"; 这个条件一直为true，严重的SQL注入
		// 4、获取Statement
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			System.out.println("--------员工信息--------");
		}
		
		statement.close();
		connection.close();
	}
	
	// 解决SQL注入的问题
	@Test
	public void test03() throws ClassNotFoundException, SQLException {
		// 员工自己查询自己的信息：从键盘输入员工的新能，查询自己的信息
		
		// 1、加载驱动类
		Class.forName("com.mysql.cj.jdbc.Driver");
				
		// 2、获取连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection connection = DriverManager.getConnection(url, "root", "yudongayng");
				
				
		// 员工输入
		Scanner input = new Scanner(System.in);
		System.out.println("输入员工名字:");
		String name = input.nextLine(); // 输入：孙红雷' or '1'='1
				
		// 3、编写SQL
		// String sql = "SELECT * FROM t_employee WHERE name = '" + name  +"'";
		// "SELECT * FROM t_employee WHERE name = '孙红雷' or '1'='1'"; 这个条件一直为true，严重的SQL注入
		String sql = "SELECT * FROM t_employee WHERE name = ?";
		
		
		// 4、获取Statement
//		Statement statement = connection.createStatement();
		PreparedStatement prepareStatement = connection.prepareStatement(sql);

		// 进一步，设置?
		prepareStatement.setString(1, name);
		
		ResultSet executeQuery = prepareStatement.executeQuery();
		while (executeQuery.next()) {
			System.out.println("--------员工信息--------");
		}
		
		
		prepareStatement.close();
		connection.close();
	}
	
	// 解决存放二进制问题
	/*
	 * 图片太大：
	 * （1）表结构修改，把blob修改为mediumblob
	 * mysql> desc t_user;
	 * +----------+--------------+------+-----+---------+-------+ 
	 * | Field    | Type         | Null | Key | Default | Extra |
	 * +----------+--------------+------+-----+---------+-------+ 
	 * | username | varchar(100) | NO   |     | NULL    |       | 
	 * | password | varchar(100) | NO   |     | NULL    |       | 
	 * | photo    | mediumblob   | YES  |     | NULL    |       | 
	 * | id       | int          | NO   | PRI | NULL    |       |
	 * +----------+--------------+------+-----+---------+-------+ 
	 * 4 rows in set (0.00 sec)
	 * 
	 * （2）修改my.ini
	 * 增加一个参数
	 * max_allowed_packet=16M
	 * 在修改my.ini之前，要先关闭MySQL，修改完后在重启MySQL
	 * 
	 * 要修改上面两个东西才能存储大的二进制数据和可以传输大量数据
	 * 
	 */
	@Test
	public void test04() throws ClassNotFoundException, SQLException, FileNotFoundException {
		
		
		// 1、加载驱动类
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2、获取连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection connection = DriverManager.getConnection(url, "root", "yudongyang");
		
		
		

		// 3、编写SQL
//		String sql = "INSERT INTO test.t_user (username, password, photo, id) VALUES('123', 'saf', ?, 0)"; // 无法处理blob

		String sql = "INSERT INTO test.t_user (username, password, photo, id) VALUES(?, ?, ?, ?)"; // 避免了拼接blob
		

		
		// 4、创建PreparedStatement
//		Statement statement = connection.createStatement();
		PreparedStatement statement = connection.prepareStatement(sql);

		// 加入一步，设置?的值
		statement.setString(1,  "张三");
		statement.setString(2, "123456");
		statement.setObject(3, new FileInputStream("F:\\Z-照片\\2017\\IMG_1198.JPG"));
		statement.setInt(4, 1);
		
		
		// 5、执行SQL
//		int update = statement.executeUpdate(sql);
		int update = statement.executeUpdate();
		System.out.println(update > 0 ? "添加成功" : "添加失败");

		// 6、关闭
		statement.close();
		connection.close();
		
		

	}

}
