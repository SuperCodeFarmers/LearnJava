package com.learn.string;

public class TestStringBuilderAndStringBufferEfficiency {
	public static void main(String[] args) {
		/*
		 * String拼接+用时:3881 String拼接+memory:103405504
		 */
		testString();

		/*
		 * StringBuilder拼接append用时:67 StringBuilder拼接append memory:4139848
		 */
		testStringBuilder();

		/*
		 * StringBuffer拼接append用时:103 StringBuffer拼接append memory:4139760
		 */
		testStringBuffer();
	}

	public static void testString() {
		long startTime = System.currentTimeMillis();
		String s = new String("0");
		for (int i = 1; i < 100000; i++) {
			s += i;
		}

		System.out.println(s);
		long endTime = System.currentTimeMillis();
		System.out.println("String拼接+用时:" + (endTime - startTime));
		long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("String拼接+memory:" + memory);
	}

	public static void testStringBuilder() {
		long startTime = System.currentTimeMillis();
		StringBuilder s = new StringBuilder("0");
		for (int i = 1; i < 100000; i++) {
			s.append(i);
		}

		System.out.println(s);
		long endTime = System.currentTimeMillis();
		System.out.println("StringBuilder拼接append用时:" + (endTime - startTime));
		long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("StringBuilder拼接+memory:" + memory);
	}

	public static void testStringBuffer() {
		long startTime = System.currentTimeMillis();
		StringBuffer s = new StringBuffer("0");
		for (int i = 1; i < 100000; i++) {
			s.append(i);
		}

		System.out.println(s);
		long endTime = System.currentTimeMillis();
		System.out.println("StringBuffer拼接append用时:" + (endTime - startTime));
		long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("StringBuffer拼接appendmemory:" + memory);
	}

}
