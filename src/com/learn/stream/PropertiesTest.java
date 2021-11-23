/**
 * 
 */
package com.learn.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @className: PropertiesTest
 * @Description: TODO
 * @author: YuDongYang
 * @date: 2021年11月21日
 */
public class PropertiesTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader("src\\mysql.properties"));
		properties.list(System.out);
		System.out.println("--------------------------------------");
		String user = properties.getProperty("user");
		String pwd = properties.getProperty("pwd");
		String ip = properties.getProperty("ip");
		System.out.println(user);
		System.out.println(pwd);
		System.out.println(ip);

		properties.clear();
	}
}
