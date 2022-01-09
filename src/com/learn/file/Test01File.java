package com.learn.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

/*
 * java.io.File类
 * 	文件和目录 路径名的抽象表示形式
 * 	通俗的将：File类的对象代表一个文件或一个目录（文件夹）
 * 
 * 1、路径的分隔符
 * Windows：`\` 和 `/`
 * 其他平台：`/`
 * 网络地址：http://www.baidu.com/index.html
 * 现在写路径分隔符：（1）`/`。（2）File.separator
 * 
 * 2、API
 * （1）获取文件或目录的详细信息
 * 
 * 
 */

public class Test01File {
	@Test
	public void test05() throws IOException {
		// 相对路径：相当于当前的项目
		File file = new File("../../系统玩法/B-buff系统\\加速系统.doc");
		System.out.println("文件的路径:" + file.getPath());
		System.out.println("文件的绝对路径:" + file.getAbsolutePath());
		System.out.println("文件的相对路径:" + file.getCanonicalPath());
	}

	@Test
	public void test04() throws IOException {
		// 相对路径：相当于当前的项目
		File file = new File("系统玩法/B-buff系统/加速系统.doc");
		System.out.println("文件的路径:" + file.getPath());
		System.out.println("文件的绝对路径:" + file.getAbsolutePath());
		System.out.println("文件的相对路径:" + file.getCanonicalPath());
	}

	@Test
	public void test03() throws IOException {
		File file = new File("E:\\Q2\\Work\\系统玩法\\B-buff系统\\加速系统.doc");
		System.out.println("文件的路径:" + file.getPath());
		System.out.println("文件的绝对路径:" + file.getAbsolutePath());
		System.out.println("文件的相对路径:" + file.getCanonicalPath());
	}

	@Test
	public void test02() {
		File file = new File("F:\\于东洋.doc");
		System.out.println("文件名:" + file.getName());
		System.out.println("文件大小:" + file.length());
		System.out.println("文件是否是隐藏文件:" + file.isHidden());
		System.out.println("文件是否存在:" + file.exists());
		System.out.println("文件是否可读:" + file.canRead());
		System.out.println("文件是否可写:" + file.getParent());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("文件最后修改时间:" + format.format(file.lastModified()));

	}

	public void test01() {
		File ioBJ = new File("E:\\文件\\dog.dat");
		File ioBJ2 = new File("E:/文件/dog.dat");
		File ioBJ3 = new File("E:" + File.separator + "文件" + File.separator + "dog.dat");

	}
}
