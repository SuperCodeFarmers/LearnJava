package com.learn.collection;

import java.util.Vector;

import org.junit.jupiter.api.Test;

/*
 * Vector:
 * （1）new Vector():初始化为长度为10的数组，默认增量为0
 * （2）add(E e):
 * 		默认扩容为原来的2倍
 * 		如果你手动指定了capacityIncrement的值，那么可以按照你指定的增量进行扩容。
 * （3）add(index, e)
 * 		1、考虑扩容
 * 		2、移动元素
 * 		3、添加元素
 * 		4、元素个数增加
 * （4）remove(int index)
 * 		1、计算要移动元素的个数
 * 		2、如果需要移动，调用System.arrayCopy方法进行移动
 * 		3、把elementData[--elementCount] = null
 * （5）remove(Object o)
 * 		1、查找obj的下标
 * 		2、如果不是-1就调用remove(index)进行删除
 * （6）indexOf(Object o)
 * 		对obj分情况讨论:(1)是null2 (2)不是null
 * 
 */

public class TestVector {

	@Test
	public void test1() {
		Vector<Integer> v = new Vector();
		
		v.add(1);
		v.insertElementAt(2, 1);
		v.remove(0);
		v.remove(v)
	}

}
