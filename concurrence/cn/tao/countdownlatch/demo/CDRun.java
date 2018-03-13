package cn.tao.countdownlatch.demo;

import java.util.concurrent.CountDownLatch;
/*
 * @author tao wenjun
 * 
 */
public class CDRun {

	public static void main(String[] args) {
		CountDownLatch count = new CountDownLatch(10);
		MyThread[] threads = new MyThread[Integer.parseInt(""+count.getCount())];
		
		for(int i=0;i<threads.length;i++){
			threads[i] = new MyThread(count);
			threads[i].start();
		}
		try {
			count.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("all back");

	}

}
