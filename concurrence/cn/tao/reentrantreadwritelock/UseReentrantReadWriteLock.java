package cn.tao.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 *@author  tao wenjun
 *@date 2018��5��2��
 *UseReentrantReadWriteLock��ʹ��������
 */

public class UseReentrantReadWriteLock {
	private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
	private ReadLock readLock = reentrantReadWriteLock.readLock();
	private WriteLock writeLock = reentrantReadWriteLock.writeLock();
	
	public void read(){
		try {
			readLock.lock();
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"�����������");
			Thread.sleep(3000);
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"�˳���������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			readLock.unlock();
		}
	}
	
	public void write(){
		try {
			writeLock.lock();
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"����д������");
			Thread.sleep(2000);
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"�˳�д������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			writeLock.unlock();
		}
	}
}
