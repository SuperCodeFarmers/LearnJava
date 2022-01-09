package com.learn.file;

import java.io.File;
import java.io.FileFilter;

import org.junit.jupiter.api.Test;

/*
 * 文件或目录过滤器
 */

public class Test03FileFilter {

	@Test
	public void test01() {
		// 列出E:\IdeaProjects\netty\src目录下的所有.java文件
		File dir = new File("E:\\IdeaProjects\\netty\\src\\main\\java\\com\\learn\\netty\\GroupChat");
		File[] listFiles = dir.listFiles(new FileFilter() {
			
			// File pathname表示这个目录的下一级的每一个文件或目录
			// 这个方法返回true，说明要保留
			@Override
			public boolean accept(File pathname) {
				
				return pathname.getName().endsWith(".java");
			}
		});

		for (File file : listFiles) {
			System.out.println(file);
		}
	}
}
  