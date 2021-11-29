package com.learn.collection;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 使用foreach遍历时，进行删除，可能报错，也可能不报错，会导致结果不确定，所以不要用foreach去删除
 * 因为使用foreach删除时，调用的是集合的remove方法，便利吊用的是Iterator的遍历方法,那么就导致结果不一致。
 * 集合为了避免这种错误，设计了java.util.ConcurrentModificationException异常，有时候可能不报异常，那么我们最后避免使用foreach删除
 */

public class TestForeach {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("张三");
		c.add("李四");
		c.add("王五");
		for (Object object : c) {
			String str = (String) object;
			if ("王五".equals(str)) {
				c.remove(object);
			}
		}
		System.out.println(c);
	}

}
