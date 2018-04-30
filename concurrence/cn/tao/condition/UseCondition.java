package cn.tao.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author  tao wenjun
 *@date 2018��4��30��
 *ʹ��Condition
 */

public class UseCondition {
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void method1(){
		try {
			lock.lock();
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"����ȴ�״̬������");
			Thread.sleep(3000);
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"�ͷ���");
			condition.await();
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"����ִ�С�����");
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
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"����ȴ�״̬������");
			Thread.sleep(3000);
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"�ͷ���");
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
