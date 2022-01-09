package com.learn.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

/*
 * 文件的IO操作：
 * Reader系列：
 * （1）int read()：读取单个字符。正常返回Unicode编码值
 * （2）int read(char[] cbuf)：将字符读入一个数组。  
 * （3）abstract int read(char[] cbuf, int off, int len)：读取多个字符，读取的字符放到cbuf数组中，从cbuf的[off]开始存储，最多读取len个。  

 * 
 * 一、读取一个纯文本的文件
 * 步骤：
 * (1)选择IO流，创建IO流对象
 * (2)读/写操作
 * (3)关闭IO流，释放资源
 * 
 */

public class Test05FileIO {
	@Test
	public void test03() throws IOException {
		// 1、选择IO流
		// 因为是操作纯文本文件，所以这里选择字符流
		// 因为是读取操作，所以选择字符输入流 FileReader
		FileReader fileReader = new FileReader("src/1.txt"); // 相对路径，相对于当前的项目
		
		// 2、读取文件内容
		// 数据流向：1.txt ---> fileReader流中 --->从流中开始读取
		char[] buf = new char[100];
		while (true) {
			int len = fileReader.read(buf);
			if (len == -1) {
				break;
			}
			System.out.println(new String(buf, 0, len));
		}
		
		// 3、关闭IO流
		fileReader.close();
	}
	
	
	@Test
	public void test02() throws IOException {
		// 1、选择IO流
		// 因为是操作纯文本文件，所以这里选择字符流
		// 因为是读取操作，所以选择字符输入流 FileReader
		FileReader fileReader = new FileReader("src/1.txt"); // 相对路径，相对于当前的项目
		
		// 2、读取文件内容
		// 数据流向：1.txt ---> fileReader流中 --->从流中开始读取
		char[] buf = new char[100];
		int read = fileReader.read(buf, 0, 100); // 返回成功读取的字符数
		System.out.println(read);
		System.out.println(buf);
		
		// 3、关闭IO流
		fileReader.close();
	}
	

	@SuppressWarnings("resource")
	@Test
	public void test01() throws IOException {
		// 1、选择IO流
		// 因为是操作纯文本文件，所以这里选择字符流
		// 因为是读取操作，所以选择字符输入流 FileReader
		FileReader fileReader = new FileReader("src/1.txt"); // 相对路径，相对于当前的项目
		
		// 2、读取文件内容
		// 数据流向：1.txt ---> fileReader流中 --->从流中开始读取
		int read = fileReader.read();
		System.out.println(read);
	}
}
