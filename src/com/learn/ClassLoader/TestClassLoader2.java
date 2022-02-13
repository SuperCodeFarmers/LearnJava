package com.learn.ClassLoader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.jupiter.api.Test;

/*
 * 
 * 类加载器的作用：
 * 1、本质工作：加载类
 * 2、顺便可以用它来加载“类路径下”的资源文件
 * 	例如：src下(编译后对应bin目录)有一个资源文件，配置文件：jdbc.properties
 * 
 * ClassLoader类加载器的类型：
 * 		getResourceAsStream("资源文件的路径名")
 * 
 * SourceFolder:源代码文件夹，一般会单独用一个config这种SourceFolder来装配置文件、等价于src
 * 不同于普通的Folder
 * 
 */

public class TestClassLoader2 {
	@Test
	public void test04() throws IOException {
		Properties properties = new Properties();
		// 资源文件在项目下
		properties.load(new FileInputStream("out.properties"));
		System.out.println(properties);
	}
	
	
	@Test
	public void test03() throws IOException {
		Properties properties = new Properties();
		Class clazz = TestClassLoader2.class;
		ClassLoader loader = clazz.getClassLoader();
		// 资源文件在包中
		InputStream in = loader.getResourceAsStream("com/learn/ClassLoader/demo.properties");
		properties.load(in);
		System.out.println(properties);
	}

	@Test
	public void test02() throws IOException {
		Properties properties = new Properties();
		Class clazz = TestClassLoader2.class;
		ClassLoader loader = clazz.getClassLoader();
		InputStream in = loader.getResourceAsStream("jdbc.properties");
		properties.load(in);
		System.out.println(properties);
		System.out.println(properties.getProperty("user"));
	}

	@SuppressWarnings("all")
	@Test
	public void test01() throws IOException {
		// 相对路径在项目的根目录下，不是相对src下
		// FileReader fr = new FileReader("src/jdbc.properties");
		// 我们不能指定目录，因为当我们打包后，发给别人的时候，不知道资源文件在那个目录
		FileReader fr = new FileReader("bin/jdbc.properties");

		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		System.out.println(str);
		br.close();
		fr.close();
	}
}
