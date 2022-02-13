package com.learn.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * 数据库的连接：
 * 	相当于TCP/IP协议变成的Socket，每一个客户端，每一次连接都有一个独立的Socket
 * 	TCP协议：可靠的，面向连接的。。。
 * 		在连接之前有三次握手，断开连接的时候四次挥手等操作。
 * 
 * 每一次获取连接和释放连接是一次高成本的操作
 * （1）如果我们每次为了执行SQL时，都是向数据库服务器要新的连接，用完之后直接释放掉，那么成本很高。
 * （2）如果每一个客户端每次为了自行SQL时，都是向数据库服务器要新的连接，如果同时在线人数很多，并发操作很多时，
 * 		会导致数据库服务器的压力很大。因为对于服务器来说，每一个连接都有一个Socket，都有一个线程，数据库服务器很可能挂了。
 * 
 * 如何解决这个问题？
 * 	可以设计一个数据库连接池。
 * 	这个数据库连接池先提前准备好一些连接，那么等用户需要用到连接时，不用创建新的，从这个池中直接哪一个现成的。
 * 	当用户用完后，返回池中，给下一个人继续使用。
 * 
 * 	这个数据库连接池有几个参数：
 * 	（1）初始化连接数：即一开始准备的连接数量，例如：10个
 * 	（2）最大连接数：即数据库服务器最多能承受多少个，例如：100个
 * 	（3）每次增量：如果10个不够了，会增加多少，直到达到100个。
 * 	（4）如果到达100个，怎么办？让客户等待，等待时间
 * 		1.让用户无限制等待
 * 		2.等待xx时间后，返回异常，告知客户端，连接超时。
 * 			
 * 
 * 一个项目，连接池创建一个，但是池中的连接可以很多个。
 * 
 * 数据库连接池又称为数据源。DataSource
 * 
 * 
 * 
 * 
 * 市面上有很多数据库连接池技术：
 * （1）DBCP：是Apache提供的数据库连接池，速度相对c3p0较快，但因自身存在BUG，Hibernate3已不再提供支持
 * （2）C3P0：是一个开源组织提供的一个数据库连接池，速度相对较慢，稳定性还可以
 * （3）	Proxool：
 * （4）	BoneCP：是一个开源组织提供的数据库连接池，速度快
 * （4）Druid(德鲁伊)：阿里提供的数据库连接池
 * 。。。。。。
 * 
 * 数据库连接池的优点：
 * （1）资源重用：
 * 		由于数据库连接得以重用，避免了频繁创建，释放连接引起的大量性能开销。另一方面也增加了系统运行环境的平稳性。
 * （2）更快的系统反应速度
 * 		数据库连接池在初始化过程中，往往已经创建了若干数据库连接置于连接池中备用。此时连接的初始化工作均已完成。
 * 		对于业务请求处理而言，直接利用现有可用连接，避免了数据库连接初始化和释放过程的时间开销，从而减少了系统的响应时间
 * （3）新的资源分配手段
 * 		对于多应用共享同意数据库的系统而言，可在应用层通过数据库连接池的配置，实现某一应用最大可用数据库连接数的现在，
 * 		避免某一应用独占所有的数据库资源
 * （4）统一的连接管理，避免数据库连接泄露
 * 		在较为完善的数据库连接池实现中，可根据预先的占用超时设定，强制回收被占用连接，
 * 		从而避免了常规数据库连接操作中可能出现的资源泄露
 * 	
 * 
 * 3、如何使用Druid(德鲁伊)数据库连接池？
 * 步骤：
 * （1）引入jar包
 * 	放到libs中，并添加到Build Path中
 * 
 * 方式一：
 * （1）手动创建数据库连接池对象，在代码中硬编码配置参数。例如test01()
 * 
 * 
 * 方式二：例如test03()
 * （1）在配置文件中写配置参数
 * （2）在代码中用配置文件创建连接池对象
 * 	参数：参数名时固定的
 * url:
 * username：用户名
 * password：密码
 * driverClassName：驱动类名
 * initialSize：初始化连接数
 * maxActive：最大连接数
 * maxWait：当池中的连接都被占用了，新用户的等待时间，如果超过时间，就异常返回。
 * ....
 * 
 * maxIdle：
 * minIdle：
 * 		得保证池中释放掉一些连接后，最少需要保留几个，以备不时之需
 * 
 * （3）获取连接对象
 * 数据库连接池对象.getConnection()
 * 
 * （4）用完后，close()返还连接给数据库连接池
 * 
 * 有了数据库连接池，无非改变的是获取数据库连接的方式而已，其他的不变。
 * 
 */


public class TestJDBC_07_Pool {

	@Test
	public void test01() throws Exception {
		Properties properties = new Properties(); // hashTable的子类，特点：key和value都是string类型
		properties.setProperty("url", "jdbc:mysql://localhost:3306/test");
		properties.setProperty("username", "root");
		properties.setProperty("password", "yudongyang");
		DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
		
		System.out.println(dataSource.getClass());
	}
	
	@Test
	public void test02() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("yudongyang");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setInitialSize(5);
		dataSource.setMaxWait(1);
		System.out.println(dataSource);
	}
	
	@Test
	public void test03() throws Exception {
		Properties properties = new Properties();
		// TestJDBC_07_Pool.class：得到当前Class对象
		// xx.getClassLoader()：获取类加载器对象
		// 类加载器对象.getResourceAsStream()：加载资源文件，并且把配置文件中的数据封装到Properties对象
		// 这个资源文件格式：key=value
		properties.load(TestJDBC_07_Pool.class.getClassLoader().getResourceAsStream("Durid.properties"));
	
		DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
		
		// 冲数据库连接池中拿连接
		for (int i = 0; i < 30; i++) {
			Connection connection = dataSource.getConnection();
			System.out.println("第" + (i + 1) + "个连接：" + connection);
			// connection.close(); // 归还连接
		}
		
	}
	
}


























