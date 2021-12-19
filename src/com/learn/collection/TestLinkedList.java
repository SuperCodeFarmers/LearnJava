package com.learn.collection;

import java.util.LinkedList;

/*
 * LinkedList：源码分析
 * （1）new LinkedList():什么也没有做，没有创建节点
 * （2）add(E e)
 *     void linkLast(E e) {
 *     // 保存一下最后一个节点
        final Node<E> l = last;
        
        // 创建一个新节点，新节点的prev是之前的最后一个节点
        // 				新节点的next是null，没有
        final Node<E> newNode = new Node<>(l, e, null);
        
        // 新节点成为最后一个节点
        last = newNode;
        
        if (l == null)
        	// 如果之前的节点为空，则新节点也是第一个节点
            first = newNode;
        else
        	// 如果之前的的节点不是空，原来最后一个节点的next指向新节点，让新节点成为最后一个节点
            l.next = newNode;
        size++;
        modCount++;
    }
 * 
 * （3）删除()
 * E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item; // 保存返回值数据
        final Node<E> next = x.next; // 保存被删除节点的下一个节点
        final Node<E> prey = x.prev; // 保存被删除节点的前一个节点

		
        if (prey == null) {
        	// 被删除节点的前一个节点为空，说明被删除节点是头结点
        	// 把第一个节点设置为被删除节点的下一个节点
            first = next;
        } else {
        	// 被删除节点的前一个节点不为空，说明被删除节点不是头结点
        	 
			// 把被删除节点的上一个节点的next指向，指向被删除节点的下一个节点
            prev.next = next;
            // 断开被删除节点与前一个节点的联系
            x.prev = null;
        }

        if (next == null) {
            // 被删除节点的下一个节点为空，说明被删除节点是尾节点
            // 把最后一个节点设置为被删除节点的前一个节点
            last = prey;
        } else {
        	// 被删除节点的下一个节点为空，说明被删除节点不是尾节点
        	 
        	// 把被删除节点的prey指向设置为被删除节点的前一个节点
            next.prev = Prey;
            // 把被删除节点与下一个节点的联系断开
            x.next = null;
        }

        x.item = null; // 把被删除节点的数据清空
        size--;
        modCount++;
        return element;
    }
 * 
 * 
 */

public class TestLinkedList {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add("xxx");
		list.remove("xxx");
	}
}
