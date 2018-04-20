package cn.tao.thread.syn;
/**
 *@author  tao wenjun
 *@date 2018Äê4ÔÂ20ÈÕ
 *
 */

public class ThreadA extends Thread {
	private MyObject object;
	
	public ThreadA(MyObject object){
		this.object = object;
	}
	
	public void run(){
		object.methodA();
	}
}
