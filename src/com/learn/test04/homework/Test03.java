/**
 * 
 */
package com.learn.test04.homework;

/**
 * @className: Test03
 * @Description: TODO
 * @author: YuDongYang
 * @date: 2021年10月30日
 */

/*
 * 案例：创建和启动2个子线程，一个打印奇数，一个打印偶数
 * （1）要求实现交替打印
 * （2）每个数打印间隔1秒
 */
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintNumber p = new PrintNumber();
		
		MyThread t1 = new MyThread(p);
		MyThread t2 = new MyThread(p);
		t1.start();
		t2.start();
	}

}

class PrintNumber{
	private int num = 1;
	
	public synchronized void pirnt() {
		try {
			this.notify();
			System.out.println(Thread.currentThread().getName() + ":" + num);
			num++;
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MyThread extends Thread{
	private PrintNumber p;
	
	public MyThread(PrintNumber p) {
		super();
		this.p=p;
	}
	
	@Override
	public void run() {
		while(true) {
			p.pirnt();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}