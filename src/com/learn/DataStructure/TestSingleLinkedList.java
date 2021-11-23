/**
 * 
 */
package com.learn.DataStructure;

/**
 * @className: TestSingleLinkedList
 * @Description: TODO
 * @author: YuDongYang
 * @date: 2021年11月7日
 */
public class TestSingleLinkedList {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("10,11");
		list.add("12,13");
		System.out.println(list.size());
	}

}
