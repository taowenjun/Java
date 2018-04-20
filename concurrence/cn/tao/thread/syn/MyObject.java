package cn.tao.thread.syn;
/**
 *@author  tao wenjun
 *@date 2018Äê4ÔÂ20ÈÕ
 *
 */

public class MyObject {
	
	synchronized public void methodA(){
		System.out.println("method A1");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("method A2");
	}
	
	synchronized public void methodB(){
		System.out.println("method B1");
		try {
			Thread.sleep(52);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("method B2");
	}
}
