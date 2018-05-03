package cn.tao.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *@author  tao wenjun
 *@date 2018年5月3日
 *重入锁
 */

public class UseReentrantLock {

	private ReentrantLock lock = new ReentrantLock();
	
	public void method1(){
		try {
			lock.lock();
			System.out.println("当前线程："+Thread.currentThread().getName()+"进入method1。。。");
			Thread.sleep(1000);
			System.out.println("当前线程："+Thread.currentThread().getName()+"退出method1。。。");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void method2(){
		try {
			lock.lock();
			System.out.println("当前线程："+Thread.currentThread().getName()+"进入method2。。。");
			Thread.sleep(2000);
			System.out.println("当前线程："+Thread.currentThread().getName()+"退出method2。。。");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final UseReentrantLock ur = new UseReentrantLock();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
			    ur.method1();
			    ur.method2();
			}
			
		},"t1");
		
		t1.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
