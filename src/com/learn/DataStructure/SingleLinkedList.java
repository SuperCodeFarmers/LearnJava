package com.learn.DataStructure;

public class SingleLinkedList {
	// 这里不需要数组，不需要其他的复杂结构，我只要记录单向链表的“头”节点
	private Node first; // first中记录的是第一个节点的地址
	private int total; // 这里我们记录total是为了后面处理的方便，例如：当用户获得链表的有效元素个数是，不用现数，而是直接返回

	private class Node {
		Object data;
		Node next; // 因为next中记录下一个结点的地址，因此类型是节点类型
		// 这里data, next没有私有化，是希望在外部类中可以不需要get/set,而是直接”节点对象.data“，”节点对象.next“使用

		Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public int size() {
		return total;
	}
	
	public Object[] getAll() {
		// (1) 创建一个数组，长度为total
		Object[] all = new Object[total];
		Node node = first;
		int index = 0;
		while (node != null) {
			all[index++] = node.data;
			node = node.next;
		}
		return all;
	}

	public void add(Object obj) {
		/*
		 * 1、把obj的数据，包装成一个Node类型节点的对象 
		 * 2、把新节点”链接“当前节点的最后 
		 * 	（1）当前节点是第一个节点 如何判断是否是第一个if(first == null) 说明暂时没有第一个 
		 * 	（2）先找到目前的最后一个节点，把新节点链接到他的next中 
		 * 		如何判断是否是最后一个节点 if(node.next == null)，说明就是最后一个节点
		 */

		// （1）把obj数据，包装成Node类型节点对象
		Node newNode = new Node(obj, null);
		if (first == null) {
			// 说明newNode是第一个
			first = newNode;
		} else {
			Node node = first;
			while (node.next != null) {
				node = node.next;
			}
			node.next = newNode;
		}
		total++;
	}
	
	public void remove(Object obj) {
		Node node = first;
		if (node.data.equals(obj)) {
			first = node.next;
			total--;
			return;
		}
		while (node.next != null) {
			if (node.next.equals(obj)) {
				node.next = node.next.next;
				total--;
				return;
			}
			node = node.next;
		}
	}
}
