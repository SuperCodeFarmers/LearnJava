package com.learn.generic;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/*
 * 泛型的好处:
 * （1）安全
 * （2）避免类型转换
 */

public class TestGenericGood {

	@Test
	public void test1() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("李四");
//		list.add(111);// 编译报错，因为我告诉ArrayList,我的元素类型是String,所以Integer对象进不去

		// 此时不需要Object处理了,因为它知道里面的元素是String
		for (String string : list) {
			System.out.println("名字的字数:" + string.length());
		}
	}
}
