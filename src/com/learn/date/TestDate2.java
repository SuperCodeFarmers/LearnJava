package com.learn.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.jupiter.api.Test;

/*
 * 二、JDK1.8之后引入了新的日期API
 * 
 * 旧问题：
 * （1）偏移性
 * （2）对象的可变性问题
 * 		不可变对象：String、包装类对象，修改就会产生新对象
 * 
 * 大多数程序员认为，一个日期时间的对象，应该对应一个日期时间的点，不应该改变
 * 如果想笑代表另一个日期时间，应该用另一个对象来表示
 * 即对象日期时间对象的修改，应该产生新对象，而不是修改原有的旧对象
 * 新版的日期时间对象，不可改变，一旦修改就会产生新对象
 * 
 * （3）格式化：旧版只支持Date类型
 * （4）旧版的日期时间API：它不是线程安全的，不能处理闰秒
 * 
 * 新版的日期时间API对旧版的有补充
 * 
 * 1、基本类型
 * LocalDate：本地日期
 * LocalTime：本地时间
 * LocalDateTime：本地日期和时间
 * 
 * 这三个代替了原来的java.util.Date和java.txt.Calendar
 * 
 * (1)now()/now(ZoneId zone):根据当前时间创建对象
 * (2)of():根据日期/时间创建对象
 * (3)getxxxx:
 * (4)plusXxxx:加上什么
 * (5)minusXxxx:减去什么
 * (6)isLeapYear:是否是闰年
 * 
 * 2、日期格式化：
 * 对应于老版：SimpleDateFormat
 * 
 * 
 */

public class TestDate2 {

	@Test
	public void test10() {
		LocalDateTime now = LocalDateTime.now();
//		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG); // 2021年11月3日
//		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT); // 2021/11/3
		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM); // 2021年11月3日

		
		String format = df.format(now);
		System.out.println(format);
	}

	@Test
	public void test9() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter df = DateTimeFormatter.ISO_DATE_TIME;
		String format = df.format(now); // 2021-11-03T00:13:50.8069092
		System.out.println(format);
	}

	@Test
	public void test8() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒 SSSS毫秒 E 是这一年的D天");

		String format = df.format(now);
		System.out.println(format);
	}

	@Test
	public void test7() {
		// 当前时间减去100天的日期
		LocalDate now = LocalDate.now();
		LocalDate minusDays = now.minusDays(100);
		System.out.println(minusDays);
	}

	@Test
	public void test6() {
		// 当前时间加上160天的日期
		LocalDate now = LocalDate.now();
		LocalDate plusDays = now.plusDays(160);
		System.out.println(plusDays);
	}

	@Test
	public void test5() {
		LocalDate old = LocalDate.of(2020, 1, 2);
		System.out.println(old.getDayOfYear());
	}

	@Test
	public void test4() {
		LocalDate old = LocalDate.of(2020, 1, 2);
		System.out.println(old);
	}

	@Test
	public void test3() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
	}

	@Test
	public void test2() {
		LocalTime now = LocalTime.now();
		System.out.println(now);
	}

	@Test
	public void test1() {
		LocalDate now = LocalDate.now();
		System.out.println(now);
	}
}
