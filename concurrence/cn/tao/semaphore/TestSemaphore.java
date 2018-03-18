package cn.tao.semaphore;

import java.util.concurrent.Semaphore;

/*
 * @author Tao wenjun 
 * 测试信号量的acquire()和release()方法
 */
public class TestSemaphore {

	public static void main(String[] args) {
		try {
			Semaphore semaphore = new Semaphore(5);
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			semaphore.acquire();
			System.out.println(semaphore.availablePermits());
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			System.out.println(semaphore.availablePermits());
			semaphore.release(4);
			System.out.println(semaphore.availablePermits());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
