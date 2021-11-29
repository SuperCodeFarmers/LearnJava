package com.learn.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import org.junit.jupiter.api.Test;

/*
 * List接口的实现类：
 * 1、Vector:动态数组
 * 	物理结构:数组
 * 2、ArrayList:动态数组
 * 	物理结构:数组
 * 3、Stack:栈，它是Vector的子类
 * 	物理结构：数组
 * 4、LinkerList：双向链表
 * 	物理结构：链表
 * 
 * 二、Vector和ArrayList的区别？（同时也是面试题）
 * Vector：是最早版本的动态数组（旧版本），线程安全的（有线程同步），不够后扩容为原来的2倍
 * 		Vector支持的遍历集合的方式有：（1）foreach（2）Iterator（3）支持旧版本的Enumeration迭代器
 * ArrayList：相对Vector来说心一点，线程不安全（没有线程同步的），不够后扩容为原来的1.5倍，
 * 
 * 扩容的区别：
 * 2倍：造成空间浪费的可能性更大
 * 1.5倍：造成扩容的次数增大
 * Vector和ArrayList的使用时,为了避免空间浪费和扩容次数太多,如果能够预估大概的元素,那么可以用
 * ArrayList(int initialCapacity)和Vector(int initialCapacity)直接初始化为一定容量的数组
 * 
 * 
 * StringBuffer和StringBuilder类似
 * 
 * 
 * 三、Stack:栈
 * 先进后出（FILO）或者后进先出（LIFO：Last In First Ount）
 * Stack是Vector的子类，比Vector多了几个方法，它的后进先出的特征，就是通过调用这几个方法实现的。
 * （1）E peek()：访问栈顶元素，但是不从栈顶移出元素
 * （2）E pop()：弹出栈顶元素
 * （3）E push(E item)：把元素压入栈顶，等价于add(item)
 * 		这里为了更形象，单独设计了一个push 
 * 
 * 四、LinkList：双向链表
 * 内部有一个节点的类型
 * class Node {
 * 		Object data;
 * 		Node previous;
 * 		Node next;
 * }
 * 
 * class LinkList {
 * 		Node first; // 记录第一个节点的地址
 * 		Node last; // 记录最后一个节点的地址
 * }
 * 
 * 空链表：if (first == null && last == null)
 * 有一个节点：if (first == last)
 * 第一个节点：first.previous == null
 * 最后一个节点：last.next == null
 * 
 * LinkedList可以当做双向链表、栈、队列、双端队列等数据结构使用。
 * 如何体现双向链表？
 * （1）void addFirst(E e)
 * （2）E getLast()
 * （3）boolean offerFirst(E e)：在开头插入指定元素
 * （4）boolean offerLast(E e)：在列表尾部插入指定元素
 * （5）int indexOf(Object o)：从first开始查找
 * （6）int lastIndexOf(Object o)：从last开始查找
 * （7）E get(int index)
 * 			先判断index是靠前还是靠后，然后按最少的遍历次数查找元素
 * 如何体现栈？
 * （1）E peek()
 * （2）E pop()
 * （3）E push(E item)
 * 
 * 如何体现队列？实现了Queue的接口
 * 队列：先进先出（FIFO）
 * offer(e)：插入队头
 * poll()：移除队头元素
 * peek()：检查队头元素
 *  
 *  	抛出异常 		返回特殊值 
 *  插入:add(e) 		offer(e) 
 *  移除:remove() 	poll() 
 *  检查:element() 	peek() 


 * 
 * 如何体现双端队列？
 * 
 * 下表总结了上述 12 种方法： 
 * 
 * 		第一个元素（头部） 					最后一个元素（尾部） 
 * 		抛出异常 			特殊值 			抛出异常 			特殊值 
 * 插入：addFirst(e) 		offerFirst(e) 	addLast(e) 		offerLast(e) 
 * 移除：removeFirst() 	pollFirst() 	removeLast() 	pollLast() 
 * 检查：getFirst() 		peekFirst() 	getLast() 	peekLast() 
 * 
 * 四
 * 
 */

public class TestListmpl {

	@Test
	public void test4() {
		// 用ArrayList,实现先进后出的效果
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list.poll());
		System.out.println(list.poll());
		System.out.println(list.poll());
		System.out.println(list.poll());

	}
	
	
	@Test
	public void test3() {
		// 用ArrayList,实现先进后出的效果
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list.remove(list.size() - 1));
		System.out.println(list.remove(list.size() - 1));
		System.out.println(list.remove(list.size() - 1));

	}

	@Test
	public void test2() {
		Stack s = new Stack();
		s.push("1"); // push比add可读性更好，功能是一样的
		s.push("2");
		s.push("3");
		s.push("4");

		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

	@Test
	public void test1() {
		Stack s = new Stack();
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("4");

		System.out.println(s.peek());
		System.out.println(s.peek());
		System.out.println(s.peek());
	}
}
