/**
 * 
 */
package com.learn.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @className: ObjectOutputStream_
 * @Description: TODO
 * @author: YuDongYang
 * @date: 2021年11月20日
 */
public class ObjectOutputStream_ {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String descFileName = "e:\\xiaoming.dat";
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(descFileName));
		Employee employee = new Employee("小明", 22);
		outputStream.writeObject(employee);
		outputStream.close();
		System.out.println("对象输出成功");
		System.out.println("开始读取对象信息......");
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(descFileName));
		Object object = inputStream.readObject();
		if (object instanceof Employee) {
			Employee e = (Employee) object;
			System.out.println("object class:" + e.getClass());
			System.out.println("name:" + e.getName());
			System.out.println("age:" + e.getAge());
		}
		inputStream.close();
	}
}

class Employee implements Serializable {
	private String name;
	private int age;

	/**
	 * @param name
	 * @param age
	 */
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

}