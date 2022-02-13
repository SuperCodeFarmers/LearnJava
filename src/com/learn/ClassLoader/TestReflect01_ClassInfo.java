package com.learn.ClassLoader;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Properties;

import org.junit.Before;
import org.junit.jupiter.api.Test;

/*
 * 1、在运行时能够获取任意类型的详细信息
 * 
 * 
 * 后期的时候，在框架中，例如：spring框架，会帮我们管理很多的类
 * 而这些类不是spring写的，而是我们写的，然后在运行期间spring去加载获取的
 * 
 * 步骤：
 * （1）获取这个类的Class对象
 * （2）获取类的信息
 * 		1、包名
 * 		2、类名
 * 		3、类的修饰符
 * 			public static final int PUBLIC           = 0x00000001;
 * 			public static final int PRIVATE          = 0x00000002;
 * 			public static final int PROTECTED        = 0x00000004;
 * 			public static final int STATIC           = 0x00000008;
 * 			public static final int FINAL            = 0x00000010;
 * 			public static final int SYNCHRONIZED     = 0x00000020;
 * 			public static final int VOLATILE         = 0x00000040;
 * 			public static final int TRANSIENT        = 0x00000080;
 * 			public static final int NATIVE           = 0x00000100;
 * 			public static final int INTERFACE        = 0x00000200;
 * 			public static final int ABSTRACT         = 0x00000400;
 * 			public static final int STRICT           = 0x00000800;
 * 		4、父类
 * 		5、接口
 * 		6、属性
 * 			(1)Field[] getFields() 得到所有公共属性。
 * 			(2)Field[] getDeclaredFields() 得到所有声明的属性。
 * 		7、构造器
 * 			(1)Constructor<?>[] getConstructors() 得到公共的构造方法
 * 			(2)Constructor<?>[] getDeclaredConstructors() 得到所有声明的构造方法
 * 		8、方法
 * 			(1)Method[] getMethods() 得到公共的方法
 * 			(2)Method[] getDeclaredMethods() 得到所有声明的方法
 * 
 * 
 * 
 * 
 * 一切皆对象：
 * （1）所有的类型在内存中都是Class对象
 * （2）所有的属性都是Field对象
 * private int age;
 * 
 * 
 * 属性类型：Field类型
 * 
 * 类的概念：一类具有相同特性的事物的抽象类型
 * 所有的属性，有没有相同特征：
 * 	都是有修饰符、数据类型、名称
 * 	都有相同的行为操作：get获取值/set设置值
 * 所以把属性抽象为Field类，那么一个属性被加载到内存后，是用一个Field对象表示的。
 * 
 * 
 * 所有的构造器都有：
 * 	修饰符、名称、形参列表
 * 	都能new 对象
 * 所以把构造器抽象为Constructor类，那么一个构造器被加载到内存后，是用一个Field对象表示
 * 
 * 所有的方法都是Method对象
 * 所有的方法都有：
 * 	修饰符、返回值类型、方法名、形参列表、抛出的异常列表
 * 	都能被调用invoke
 * 	
 * 
 * 		
 */

public class TestReflect01_ClassInfo {
	private Class clazz;

	public void test01() throws IOException, ClassNotFoundException {
		// 如果这个类名是在配置文件中，先获取类名
		Properties pro = new Properties();
		pro.load(TestReflect01_ClassInfo.class.getClassLoader().getResourceAsStream("bean.properties"));
		String className = pro.getProperty("className"); // key就是bean.properties文件中的=左边的属性名

		// 1、获取这个类的Class对象
		clazz = Class.forName(className);
		System.out.println(clazz);
	}

	@Test
	public void test02() throws ClassNotFoundException, IOException {
		test01();
		// 2、获取类的详细信息

		// 获取包名
		Package pack = clazz.getPackage();
		System.out.println("包名:" + pack.getName());

		// 获取类名
		System.out.println("类名:" + clazz.getName());

		// 类的修饰符
		int mod = clazz.getModifiers();
		System.out.println("修饰符的值:" + mod);
		System.out.println("修饰符:" + Modifier.toString(mod));

		// 父类
		Class superclass = clazz.getSuperclass();
		System.out.println("父类名称:" + superclass);

		// 接口
		Class[] interfaces = clazz.getInterfaces();
		for (Class class1 : interfaces) {
			System.out.println("接口名称:" + class1.getName());
		}

		// 属性,每一个属性都是一个对象
		/*
		 * (1)Field[] getFields() 得到所有公共属性。
		 * (2)Field[] getDeclaredFields() 得到所有声明的属性。
		 */
//		Field[] fields = clazz.getFields();
		Field[] fields = clazz.getDeclaredFields();
		int count = 0;
		for (Field field : fields) {
			++count;
			System.out.println(count + "属性的修饰符:" + Modifier.toString(field.getModifiers()));
			System.out.println(count + "属性的数据类型:" + field.getType().getClass().getName());
			System.out.println(count + "属性的名称:" + field.getName());
		}
		
		/*
		 * Constructor<?>[] getConstructors()
		 * Constructor<?>[] getDeclaredConstructors()
		 */
		Constructor[] constructors = clazz.getConstructors();
		Constructor[] constructors2 = clazz.getDeclaredConstructors();
		count = 0;
		for (Constructor constructor : constructors2) {
			++count;
			System.out.println(count + "构造器的修饰符:" + Modifier.toString(constructor.getModifiers()));
			System.out.println(count + "构造器的名称:" + constructor.getName());
			Parameter[] parameters = constructor.getParameters();
			System.out.println(count + "构造器的形参列表:" + Arrays.toString(parameters));
	
		}
		
		/*
		 * Method[] getMethods()
		 * Method[] getDeclaredMethods()
		 */
		Method[] methods = clazz.getMethods();
		Method[] methods2 = clazz.getDeclaredMethods();
		count = 0;
		for (Method method : methods2) {
			++count;
			System.out.println(count + "方法的修饰符:" + Modifier.toString(method.getModifiers()));
			System.out.println(count + "方法的返回值类型:" + method.getReturnType());
			System.out.println(count + "方法的名称:" + method.getName());
			Parameter[] parameters = method.getParameters();
			System.out.println(count + "方法的形参列表:" + Arrays.toString(parameters));
			Class<?>[] exceptionTypes = method.getExceptionTypes();
			System.out.println(count + "方法的异常列表:" + Arrays.toString(exceptionTypes));
		}
	}

	@Test
	public void test03() {
		int modifiers = String.class.getModifiers();
		System.out.println(modifiers);
		System.out.println(Modifier.toString(modifiers));
	}
}
