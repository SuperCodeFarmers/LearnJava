package com.learn.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/*
 * JDK1.6的HashMap：数组+链表
 * 1、new HashMap()
 * table数组初始化为了一个长度为16的空数组
 * 
 * JDK1.7的HashMap
 * 1、new HashMap()
 * table数组初始化为了一个长度为0的空数组
 * 
 * DEFAULT_INITIAL_CAPACITY:16	默认初始化容量
 * DEFAULT_LOAD_FACTOR:0.75		默认加载因子
 * threshold：阈值/临界值，数组需要考虑扩容的阈值
 * 		threshold = capacity(容量，数组的长度) * load factor(加载因子，默认是0.75)
 * 		例如： threshold = 16 * 0.75当数组大概3/4满的时候考虑扩容
 * 思考：load factor设置为0.9和0.1有什么区别？
 * 		0.1：扩容太频繁
 * 		0.9：会导致table[index]下面的链表会很长，查询速度就低
 * 
 * 2、put()
 * 	步骤1：
 * 		发现数组table是空数组后，会把数组初始化为16的Entry类型的数组.并且把threshold计算为12。
 * 		如果你指定了数组的capacity，那么如果这个capacity不是2的n次方，会自动纠正为2的n次方
 * 
 * 为什么要纠正为2的n次方？
 * 		1、后面算index = hash & (table.length - 1)，这样才能保证index在[0, table.length - 1]范围内
 * 		2、2的n次方，根据它的散列算法，可以保证比较均匀的分散在它的数组各个位置。
 * 
 * 	步骤2：
 * 		如果key是null，特殊对待，key为null的映射关系的hash值为0，index也为0。既把所有key为null的映射关系全部放到table[0]这里。
 * 
 * 	key不为null，继续下面步骤3：
 * 	步骤3：
 * 		hash = hash(key)
 * 		为了干扰我们key的hashCode值
 * 
 * 	步骤4：
 * 		index = has & (table.length - 1)
 * 
 * 	步骤5：
 * 		先判断table[index]下面是否有映射关系的key是否和我新添加的映射关系的可以有重复的，如果有，就用新的value替换旧的value，就结束了
 * 	步骤6：
 * 		如果没有重复的，决定添加新的映射关系
 * 		①看是否需要扩容
 * 			扩容的条件：A:size达到阈值threshold B:table[index]下面已经有映射关系，既不为空
 * 		如果扩容了，会重新计算hash和index
 * 		②把新的映射关系new为一个Entry的对象,放到table[index]中，原来table[index]的映射关系作为新的映射关系的next链接起来
 * Entry相当于一个节点类型
 * class Entry{
 * 	int hash;
 * 	Object key;
 * 	Ojectt value;
 * 	Entry next;
 * }
 * 
 * 如果put的key是null值，那么会把所有key为null的值全部放到table[0]这个链表下面
 * 
 * 		③
 * 		④
 * 		⑤
 * 
 * 
 * 不是空数组：
 * 	key==null：
 * 
 * 
 */

@SuppressWarnings("rawtypes")
public class TestMapSource_HashMap17 {

	@Test
	public void test() {
		Map map = new HashMap();
	}

	@Test
	public void test01() {
		// 获取最接近number的2的n次方。
		int num = Integer.highestOneBit(12);
		System.out.println(num);
	}
}
