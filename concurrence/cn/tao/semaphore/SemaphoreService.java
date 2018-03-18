package cn.tao.semaphore;

import java.util.concurrent.Semaphore;
/*
 * @author Tao wenjun
 * 信号量服务
 */
public class SemaphoreService {

	private Semaphore semaphore = null;
	
	public SemaphoreService(int num){
		semaphore = new Semaphore(num);
	}
	
	public void testMethod(){
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()
					+" begin timer="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName()
					+" end timer="+System.currentTimeMillis());
			semaphore.release();
	        
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
