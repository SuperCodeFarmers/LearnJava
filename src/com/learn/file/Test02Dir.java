package com.learn.file;

import java.io.File;

import org.junit.jupiter.api.Test;

/*
 * 文件夹/目录他不同意文件，因为文件夹中可以放文件，或者下一级文件夹
 * （1）获取文件夹的下一级
 * 	String[] list():得到下一级文件或目录的名称
 * 	File[] listFiles():得到下一级文件或目录的File对象
 * 
 */

public class Test02Dir {


	@Test
	public void test02() {
		File dir = new File("F:/--------面试--------");
		listAllSub(dir);
	}

	public void listAllSub(File dir) {
		if (dir.isDirectory()) {
			File[] listFiles = dir.listFiles();
			for (File sub : listFiles) { // sub可能是一个文件，也可能是一个文件夹
				listAllSub(sub); // 递归调用自己
			}
		} else {
			System.out.println(dir);
		}
	}

	@Test
	public void test01() {
		File dir = new File("F:/--------面试--------");
		String[] list = dir.list();
		for (String sub : list) {
			System.out.println(sub);
		}
	}

}
