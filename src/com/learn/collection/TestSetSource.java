package com.learn.collection;

/*
 * Set的底层实现是什么？
 * 1、HashSet : 底层是HashMap
 * 2、TreeSet : 底层是TreeMap
 * 3、LinkedHashSet : 底层是LinkedHashMap
 * 
 * Set添加元素时用add(value)，而Map添加元素使用put(key, value)。
 * 发现添加到Set中的元素，是作为底层的Map的key,那么value是选用了一个Object类型的常亮对象PRESENT。
 * 所有的HashSet共用同一个PRESENT对象。
 * 所以的TreeSet共用同一个PRESENT对象。
 * 所以的LinkedHashSet共用同一个PRESENT对象。
 * 
 */

public class TestSetSource {

}
