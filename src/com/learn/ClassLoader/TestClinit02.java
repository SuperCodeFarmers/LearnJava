package com.learn.ClassLoader;

/*
 * 类的加载过程中，没有进行类的初始化
 * 
 *  1)引用静态常量不会触发此类的初始化（常量在链接阶段就存入调用类的常量池中了）。
 *  	即：静态常量不需要到类初始化就完成了
 *  
 *  2)当访问一个静态域时，只有真正声明这个域的类才会被初始化
 *  	即：当通过子类引用父类的静态变量,静态方法，不会导致子类初始化
 *  
 *  3)通过数组定义类引用，不会触发此类的初始化
 * 
 */

public class TestClinit02 {
	public static void main(String[] args) {
		System.out.println(D.NUM); // D类不会初始化，以为NUM是final的
		F.test(); // F类不会初始化，E类会初始化，因为num和test()都是在E类中声明的

		// G类不会初始化，此时还没有真正用到G类
		G[] arr = new G[5]; // 没有创建G的对象，创建的是准备用来装G对象的数组对象
	}
}

class D {
	public static final int NUM = 10;
	static {
		System.out.println("D类的初始化");
	}

}

class E {
	static int num = 11;
	static {
		System.out.println("E的初始化");
	}

	public static void test() {
		System.out.println("E类的静态方法");
	}
}

class F extends E {
	static {
		System.out.println("E的子类F的初始化");
	}
}

class G {
	static {
		System.out.println("G类的初始化");
	}
}