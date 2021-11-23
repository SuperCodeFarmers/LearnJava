package com.learn.collection;

import java.util.Arrays;
import java.util.Iterator;

/*
 * MyArrayList我们自己设计的一种数据结构
 * 
 */

public class MyArrayList implements Iterable {
	// 为什么使用object，因为只是说这个容器是用来装对象的，但是不知道用来装什么对象
	private Object[] data;
	private int total;

	public MyArrayList() {
		data = new Object[5];
	}

	public void add(Object obj) {
		// 检查是否需要扩容
		checkCapacity();
		data[total++] = obj;
	}

	/**
	 * 
	 */
	private void checkCapacity() {
		if (total >= data.length) {
			data = Arrays.copyOf(data, data.length * 2);
		}
	}

	// 返回实际元素的个数
	public int size() {
		return total;
	}

	// 返回数组的实际容量
	public int capacity() {
		return data.length;
	}

	public Object get(int index) {
		checkIndex(index);
		return data[index];
	}

	/**
	 * @param index 校验index合理性范围
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= total) {
			throw new IndexOutOfBoundsException(index + "越界");
		}
	}

	public void set(int index, Object value) {
		checkIndex(index);
		data[index] = value;
	}

	// 在[index]位置插入一个元素value
	public void insert(int index, Object value) {
		/*
		 * （1）考虑下标合理性 （2）检查总长度是否够 （3）[index]以及后面的元素往后移，把[index]位置腾出来 （4）data[index] =
		 * value 放入元素 （5）total++ 有效元素个数增加
		 */

		// 检查index合理性范围
		checkIndex(index);

		// 检查是否需要扩容
		checkCapacity();

		/*
		 * 假设total = 5, data.length = 10, index = 1 有效元素[0, 4]
		 */
		System.arraycopy(data, index, data, index + 1, total - index);

		// （3）把data[idnex] = value
		data[index] = value;
		total++;
	}

	public void remove(int index) {
		checkIndex(index);
		System.arraycopy(data, index + 1, data, index, total - index - 1);
		data[total - 1] = null;
		total--;
	}

	// 查询某个元素的个数
	public int indexOf(Object obj) {
		if (null == obj) {

		}
		for (int i = 0; i < data.length; i++) {
			if (obj.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new MyIter();
	}

	private class MyIter implements Iterator {
		private int cursor; // 游标

		@Override
		public boolean hasNext() {
			System.out.println("还有下一个");
			return cursor != total;
		}

		@Override
		public Object next() {
			System.out.println("拿到下一个");
			return data[cursor++];
		}

	}
}
