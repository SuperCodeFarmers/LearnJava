/**
 * 
 */
package com.learn.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @className: BufferWriter_
 * @Description: TODO
 * @author: YuDongYang
 * @date: 2021年11月20日
 */
public class BufferWriter_ {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		String resFilePath = "E:\\Solution.java";
		String destFilePath = "E:\\Solution2.java";

		BufferedReader reader = new BufferedReader(new FileReader(resFilePath));
		BufferedWriter writer = new BufferedWriter(new FileWriter(destFilePath, true));

		String line;
		while ((line = reader.readLine()) != null) {
			writer.write(line);
			writer.newLine();
		}
		reader.close();
		writer.close();

	}
}
