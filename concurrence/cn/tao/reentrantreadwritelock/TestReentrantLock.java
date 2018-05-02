package cn.tao.reentrantreadwritelock;
/**
 *@author  tao wenjun
 *@date 2018Äê5ÔÂ2ÈÕ
 *²âÊÔReentrantLock
 */

public class TestReentrantLock {

	public static void main(String[] args) {
		final UseReentrantReadWriteLock rrw = new UseReentrantReadWriteLock();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				rrw.read();
			}
			
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				rrw.read();
			}
			
		},"t2");
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				rrw.write();
			}
			
		},"t3");
		
		Thread t4 = new Thread(new Runnable(){

			@Override
			public void run() {
				rrw.read();
			}
			
		},"t4");
		
		Thread t5 = new Thread(new Runnable(){

			@Override
			public void run() {
				rrw.write();
			}
			
		},"t5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
