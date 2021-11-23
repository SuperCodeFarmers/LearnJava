/**
 * 
 */
package com.learn.stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * @className: InputStreamReader_
 * @Description: TODO
 * @author: YuDongYang
 * @date: 2021年11月21日
 */
public class InputStreamReader_ {
	@SuppressWarnings("resource")
	public  void main(String[] args) throws IOException {
		String srcFilePath = "e:\\a.txt";
		FileInputStream inputStream = new FileInputStream(srcFilePath);
		InputStreamReader reader = new InputStreamReader(inputStream, "gbk");
		BufferedReader br = new BufferedReader(reader);
		String s = br.readLine();
		System.out.println("读取内容：" + s);
		
		
		String descFilePath = "e:\\b.txt";
		FileOutputStream fileOutputStream = new FileOutputStream(descFilePath);
		OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "utf-8");
		writer.write(s);
		
		br.close();
		writer.close();
	}
}
