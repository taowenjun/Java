package cn.tao.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author  tao wenjun
 *@date 2018年4月30日
 *使用Condition
 */

public class UseCondition {
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void method1(){
		try {
			lock.lock();
			System.out.println("当前线程："+Thread.currentThread().getName()+"进入等待状态。。。");
			Thread.sleep(3000);
			System.out.println("当前线程："+Thread.currentThread().getName()+"释放锁");
			condition.await();
			System.out.println("当前线程："+Thread.currentThread().getName()+"继续执行。。。");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void method2(){
		try {
			lock.lock();
			System.out.println("当前线程："+Thread.currentThread().getName()+"进入等待状态。。。");
			Thread.sleep(3000);
			System.out.println("当前线程："+Thread.currentThread().getName()+"释放锁");
			condition.signal();
			System.out.println("haha");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}
