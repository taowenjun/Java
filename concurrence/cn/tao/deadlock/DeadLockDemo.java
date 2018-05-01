package cn.tao.deadlock;
/**
 *@author  tao wenjun
 *@date 2018Äê5ÔÂ1ÈÕ
 *
 */

public class DeadLockDemo {

	private static String A = "A";
	private static String B = "B";
	
	public static void main(String[] args) {
		
		new DeadLockDemo().deadLock();

	}

	private void deadLock(){
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized(A){
					try{
						Thread.sleep(2000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println("to get lock B");
					synchronized(B){
						System.out.println("1");
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				synchronized(B){
					System.out.println("to get lock A");
					synchronized(A){
						System.out.println("2");
					}
				}
			}
			
		});
		
		t1.start();
		t2.start();
	}
}
