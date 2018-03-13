package cn.tao.countdownlatch.demo;

import java.util.concurrent.CountDownLatch;
/*
 * @author tao wenjun
 * 
 */
public class MyThread extends Thread{

	CountDownLatch count = null;
	
	public MyThread(CountDownLatch count){
		this.count=count;
	}
	
	@Override
	public void run(){
		try {
			Thread.sleep(2000);
			System.out.println(this.getName()+" is ok");
			count.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
