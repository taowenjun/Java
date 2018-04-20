package cn.tao.thread.waitnotify;
/**
 *@author  tao wenjun
 *@date 2018��4��20��
 *
 */

public class ThreadB extends Thread {
	
	volatile private MyList list;
	
	public ThreadB(MyList list){
		super();
		this.list = list;
	}
	
	public void run(){
		try{
			synchronized (list) {
				if(list.size()!=5){
					System.out.println("wait begin "+System.currentTimeMillis());
					list.wait();
					System.out.println("wait end "+System.currentTimeMillis());
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
