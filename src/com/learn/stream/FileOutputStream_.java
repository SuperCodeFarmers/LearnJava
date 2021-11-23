package com.learn.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		String SrcFilePathString = "e:\\19-事务问题演示.avi";
		String DestFilePathString = "e:\\19.avi";

		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(SrcFilePathString));
		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(DestFilePathString));

		byte[] buff = new byte[1024];
		int dataLen;
		while ((dataLen = inputStream.read(buff)) != -1) {
			outputStream.write(buff, 0, dataLen);
		}
		System.out.println("拷贝成功！");
		inputStream.close();
		outputStream.close();

	}
}
