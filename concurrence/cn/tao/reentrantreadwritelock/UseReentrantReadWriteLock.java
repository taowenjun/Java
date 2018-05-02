package cn.tao.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 *@author  tao wenjun
 *@date 2018年5月2日
 *UseReentrantReadWriteLock：使用重入锁
 */

public class UseReentrantReadWriteLock {
	private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
	private ReadLock readLock = reentrantReadWriteLock.readLock();
	private WriteLock writeLock = reentrantReadWriteLock.writeLock();
	
	public void read(){
		try {
			readLock.lock();
			System.out.println("当前线程："+Thread.currentThread().getName()+"进入读。。。");
			Thread.sleep(3000);
			System.out.println("当前线程："+Thread.currentThread().getName()+"退出读。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			readLock.unlock();
		}
	}
	
	public void write(){
		try {
			writeLock.lock();
			System.out.println("当前线程："+Thread.currentThread().getName()+"进入写。。。");
			Thread.sleep(2000);
			System.out.println("当前线程："+Thread.currentThread().getName()+"退出写。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			writeLock.unlock();
		}
	}
}
