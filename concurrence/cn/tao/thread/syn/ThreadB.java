package cn.tao.thread.syn;
/**
 *@author  tao wenjun
 *@date 2018��4��20��
 *
 */

public class ThreadB extends Thread {
	private MyObject object ;
	
	public ThreadB(MyObject object){
		this.object = object;
	}
	
	public void run(){
		object.methodB();
	}
}
