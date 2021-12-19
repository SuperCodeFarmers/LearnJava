package com.learn.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

/*
 * 1、集合分为两大家族
 * （1）Collection：一组对象，单身party
 * List和Set
 * （2）Map:一组键值对，映射关系，情侣party
 * 
 * 2、Map接口
 * （1）API
 * put(Object key, Object value)
 * putAll(Map m):将另一个m中所有的映射关系都添加到当前map中
 * 
 * boolean containsKey(Object key)：是否包含某个key
 * boolean containsValue(Object value)：是否包含某个值
 * boolean isEmpty()：是否为空
 * 
 * V get(Ojectb key)：根据key获取value，不存在返回null
 * 
 *  void clear()：清空所有
 *  Object remove(Ojectb key)：根据key删除一对映射关系，并返回其key对应的value值 
 * 
 * 
 * 遍历map：
 * Map没有继承java.lang.Iterable接口，所以不支持使用foreach循环惊醒遍历
 * Map接口中没有提供Iterator iterator()方法返回迭代器对象
 * 
 * （1）Set<K> keySet()
 * 		获取所有的key，然后遍历他们
 * 这里所有的key组成了一个Set集合，因为它们不可重复
 * 
 * （2）Collection values()
 * 		获取所有的value，然后遍历他们
 * 这里所有的value组成了一个Collection系列的集合，可能重复，也可能不重复
 * 
 * （3）Set entrySet()
 * 		获取所有的映射关系，然后遍历它们。此时把一对映射关系(key, value)看成一个整体,是Entry类型的整体。
 * 因为key不可重复，那么所有的组合也就唯一了，所以所有的映射关系也就是Set集合了
 * 
 * （2）说明：任意的引用数据类型都可以作为key和value。
 * 虽然key也可以是任意类型的对象，但是习惯上，或者说我们遇到的最多的key类型是:String和Integer
 * 因为String和integer比较简单
 * 
 */

@SuppressWarnings("all")
public class TestMap {
	@Test
	public void test08() {
		Map map = new HashMap();
		String[] girls = { "翠花", "凤姐", "春香", "夏香", "秋香", "冬香" };
		map.put("张三", girls);

		ArrayList list = new ArrayList();
		list.add("小兰");
		list.add("小红");
		list.add("小白");
		map.put("李四", list);

		Set entrySet = map.entrySet();
		for (Object entry : entrySet) {
			System.out.println(entry);
		}

	}

	@Test
	public void test07() {
		Map map = new HashMap();
		map.put("张三", "张三妻子");
		map.put("李四", "李四的妻子");
		map.put("王五", "王五的妻子");

		Set entrySet = map.entrySet();
		for (Object entry : entrySet) {
			System.out.println(entry);
		}
	}

	@Test
	public void test06() {
		Map map = new HashMap();
		map.put("张三", "张三妻子");
		map.put("李四", "李四的妻子");
		map.put("王五", "王五的妻子");

		Collection values = map.values();
		for (Object value : values) {
			System.out.println(value);
		}
	}

	@Test
	public void test05() {
		Map map = new HashMap();
		map.put("张三", "张三妻子");
		map.put("李四", "李四的妻子");
		map.put("王五", "王五的妻子");

		Set keys = map.keySet();
		for (Object key : keys) {
			System.out.println(key + " -> " + map.get(key)); // 通过key得到value
		}
	}

	@Test
	public void test04() {
		Map map = new HashMap();
		map.put("张三", "张三妻子");
		map.put("李四", "李四的妻子");
		map.put("王五", "王五的妻子");

		// 获取map集合中所有的key
		Set keys = map.keySet();
		for (Object key : keys) {
			System.out.println(key);
		}
	}

	@Test
	public void test03() {
		Map map = new HashMap();
		map.put("张三", "张三妻子");
		map.put("李四", "李四的妻子");
		map.put("王五", "王五的妻子");

		System.out.println(map.remove("张三"));
		System.out.println(map.remove("其他"));
	}

	@Test
	public void test02() {
		Map map = new HashMap();
		map.put("张三", "张三妻子");
		map.put("李四", "李四的妻子");
		map.put("王五", "王五的妻子");

		System.out.println(map.containsKey("张三"));
		System.out.println(map.containsValue("王五的妻子"));

		System.out.println(map.get("李四"));
		System.out.println(map.get("其他人"));

	}

	@Test
	public void test01() {
		Map map = new HashMap();
		map.put("张三", "张三妻子");
		map.put("李四", "李四的妻子");

		System.out.println("map的键值对个数：" + map.size());
		System.out.println(map);
	}
}
