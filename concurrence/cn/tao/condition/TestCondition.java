package cn.tao.condition;
/**
 *@author  tao wenjun
 *@date 2018Äê4ÔÂ30ÈÕ
 *²âÊÔCondition
 */

public class TestCondition {

	public static void main(String[] args) {
		final UseCondition uc = new UseCondition();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				uc.method1();
			}
		},"t1");
		
        Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				uc.method2();
			}
		},"t2");
        
        t1.start();
        t2.start();
	}

}
