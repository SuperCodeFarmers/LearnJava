package com.learn.collection;

/*
 * modCount:记录当前集合倍修改的次数
 * （1）添加
 * （2）删除
 * 这两个操作都会影响元素的个数
 * 
 * 当我们使用迭代器或foreach遍历时，如果你在foreach遍历时，自动调用迭代器的迭代方法
 * 此时在遍历过程中调用了集合的add，remove方法时，modCount就会改变，
 * 而迭代器记录的modCount是开始迭代之前的，如果两个不一致，就会报异常，
 * 说明有两个或多个线路（线程）同时操作集合。这种操作有风险，为了保证结果的正确性。
 * 避免这样的情况发送，一旦发现modCount与expectedModCount不一致，立即报错。
 * 
 * 
 */

public class TestModCount {

}
