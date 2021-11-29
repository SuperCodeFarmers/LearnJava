package com.learn.collection;

import java.util.Stack;

/*
 * Stack：栈 源码分析
 * 
 * （1）peek：
 * 		返回size-1位置的元素
 * （2）pop:
 * 		1、先peek()返回栈顶元素
 * 		2、删除size-1位置的元素
 * （3）push：等价于add()
 * 		把元素添加到[size]位置，并对size+1
 * 
 */

public class TestStack {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.peek();
		s.pop();
	}
}
