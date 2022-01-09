package com.learn.ClassLoader;

/*
 * 类的加载
 * 1、加载：
 * 		把字节码读取到内存
 * 
 * 2、连接
 * 	(1)验证:确保加载的类信息符合JVM规范，例如：以cafe开头，没有安全方面的问题。
 * 	(2)准备:正式为类变量(static)分配内存并设置类变量默认初始值的阶段，这些内存都将在方法区中进行分配。
 * 		例如：给类变量(静态变量)在方法区分配内存，并赋默认值
 * 	(3)解析:虚拟机常量池内的符号引用(常量名)替换为直接引用(地址)的过程。
 * 
 * 这里1,2完成时，在方法区中已经有一个能够代表当前类的Class对象
 * 3、初始化<clinit>()
 * 类的初始化主要就是对静态的类变量进行初始化：
 * 	1)执行类构造器<clinit>()
 * 
 * 类的加载大多数情况下是1、2、3一起完成的，但是有的时候3、初始化不一起完成
 * 
 */


public class TestClassLoading {

}
