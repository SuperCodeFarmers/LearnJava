package com.learn.DataStructure;

/*
 * 数据的存储：
 * （1）变量
 * 简单类型的变量：
 * int a = 10;
 * String str = "hello";
 * 复杂类型的比哪里：
 * int[] arr = {1,2,3,4}
 * 
 * （2）数组
 * 存储一组数据
 * 这组数据可以是基本的数据类型，也可以是对象
 * int[] arr = {1,2,3,4}
 * Student[] arr = new Student[3];
 * arr[0] = new Student("张三", 23);
 * 
 * 数组的特点：
 * 1、长度是固定的
 * 2、需要额外的变量来记录数组的有效元素的个数
 * 对于程序员来说
 * 如果需要扩容等，或者要维护元素的个数，都需要大量的工作。
 * 
 * （3）其他容器：集合
 * 每一种集合都有自己的特点，适用于特定的类型
 * 
 * 2、数据存储的物理结构
 * （1）连续的存储空间：数组
 * 		元素是相邻的，在内存中需要开辟连续的存储空间
 * 		缺点：内存比较吃紧时，开辟一整块空间不好开辟
 * 		有点：访问速度比较快，因为有了首地址，然后根据下标，直接就可以找到相应的元素
 * （2）非连续的存储空间：链式
 * 		元素不一定是相邻的，在内存中不需要开辟连续的存储空间
 * 		缺点：访问速度相对数组比较慢，要从头，挨个便利
 * 		有点，不要求空间连续
 * 
 * 链式中：
 * 线性：链表
 * 非线性：树
 * 
 * 非线性和线性：
 * 线性：数组、链表、队列（数组或李娜表）、栈（数组或链表）
 * 非线性：树（二叉树）、图....
 * 
 * 数据的存储结构会影响程序的性能。
 * 
 */

public class Test01 {

}
