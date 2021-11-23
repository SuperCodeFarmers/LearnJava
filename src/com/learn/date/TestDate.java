package com.learn.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;

/*
 * 日期时间的API
 * 1、JDK1.8之前
 * 2、JDK1.8之后
 * 
 * 一、JDK1.8之前
 * 1、java.util.Date
 * （1）new Date()
 * （2）new Date()
 * （3）long getTime()
 * 
 * 2、java.util.Calendar:日历类型
 * 抽象类：他有子类GregorianCalendar
 * 
 * 3、java.util.TimeZone:时区
 * static TimeZone getTimeZone(String ID)
 * 
 * 
 * 4、java.text.DateFormat
 * java.text.SimpleDateFormat 格式化日期
 * 
 * 
 */

public class TestDate {

	@Test
	public void test10() throws ParseException {
		// 2021年11月02日 11:48:02
		String str = "2021年11月02日 11:48:02";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		Date date = sf.parse(str);
		System.out.println(date);
	}

	@Test
	public void test9() {
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		String format = sf.format(d);
		System.out.println(format); // 2021年11月02日 11:48:02
	}

	@Test
	public void test8() {
		String[] iDs = TimeZone.getAvailableIDs();
		for (int i = 0; i < iDs.length; i++) {
			System.out.println(iDs[i]);
		}
	}

	@Test
	public void test7() {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTimeZone());
	}

	@Test
	public void test6() {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		int year = calendar.get(calendar.YEAR);
		System.out.println(year);
		int month = calendar.get(Calendar.MONTH) + 1;
		System.out.println(month);

	}

	@Test
	public void test5() {
		long time = Long.MAX_VALUE;
		Date date = new Date(time);
		System.out.println(date);
	}

	@Test
	public void test4() {
		long time = 1635863763337L;
		Date date = new Date(time);
		System.out.println(date); // Tue Nov 02 22:36:03 CST 2021
	}

	@Test
	public void test3() {
		Date date = new Date();
		long time = date.getTime();
		System.out.println(time); // 1635863763337
	}

	@Test
	public void test2() {
		long timeMillis = System.currentTimeMillis();
		System.out.println(timeMillis); // 1635863680090
		// 当前系统时间距离1970-1-1 0:0:0 0毫秒的时间差，毫秒为单位
	}

	@Test
	public void test1() {
		// 得到系统时间
		Date d = new Date();
		System.out.println(d);
	}
}
