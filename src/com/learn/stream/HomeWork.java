/**
 * 
 */
package com.learn.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.junit.jupiter.api.Test;

/**
 * @className: HomeWork
 * @Description: TODO
 * @author: YuDongYang
 * @date: 2021年11月21日
 */
public class HomeWork {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		String dirPath = "e:\\mytemp";
		File file = new File(dirPath);
		if (!file.exists()) {
			// 创建
			if (file.mkdir()) {
				System.out.println("创建:" + dirPath + ",创建成功");
			} else {
				System.out.println("创建:" + dirPath + ",创建失败");

			}
		}
		String filePath = dirPath + "\\hello.txt";
		file = new File(filePath);
		if (!file.exists()) {
			if (file.createNewFile()) {
				System.out.println("创建:" + filePath + ", 创建成功");
			} else {
				System.out.println("创建:" + filePath + ", 创建失败");
			}
		} else {
			System.out.println(filePath + " 已经存在，不在重复创建......");
		}
		FileWriter fileWriter = new FileWriter(filePath);
		BufferedWriter writer = new BufferedWriter(fileWriter);
		writer.write("hello,world~~~~");
		writer.flush();
		writer.close();
	}

	@SuppressWarnings("resource")
	@Test
	public void test2() throws IOException {
		String filePath = "e:\\Solution.java";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line;
		int lineNumber = 0;
		while ((line = reader.readLine()) != null) {
			++lineNumber;
			System.out.println(lineNumber + " " + line);
		}
		reader.close();
	}

	@SuppressWarnings("resource")
	@Test
	public void test3() throws IOException {
		String filePath = "e:\\Solution.java";
		FileInputStream fileInputStream = new FileInputStream(filePath);

		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		String line;
		int lineNumber = 0;
		while ((line = reader.readLine()) != null) {
			++lineNumber;
			System.out.println(lineNumber + " " + line);
		}
		reader.close();
	}

	@SuppressWarnings("resource")
	@Test
	public void test4() throws FileNotFoundException, IOException {
		String filePath = "src\\dog.properties";
		Properties properties = new Properties();
		properties.load(new FileReader(filePath));

		properties.list(System.out);

		String name = properties.getProperty("name");
		String age = properties.getProperty("age");
		String color = properties.getProperty("color");
		Dog dog = new Dog(name, Integer.valueOf(age), color);
		System.out.println(dog);
		String descFilePath = "src\\dog.dat";
		File file = new File(descFilePath);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream stream = new ObjectOutputStream(fileOutputStream);
		stream.writeObject(dog);
		stream.flush();
		
		stream.close();
	}

}

class Dog implements Serializable {
	private String name;
	private int age;
	private String color;

	/**
	 * @param name
	 * @param age
	 * @param color
	 */
	public Dog(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", color=" + color + "]";
	}

}
