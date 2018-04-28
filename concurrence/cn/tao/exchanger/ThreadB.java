package cn.tao.exchanger;

import java.util.concurrent.Exchanger;

/**
 *@author  tao wenjun
 *@date 2018年4月28日
 *Exchanger线程B
 */

public class ThreadB extends Thread {
	
	private Exchanger<String> exchanger;
	
	public ThreadB(Exchanger<String> exchanger){
		super();
		this.exchanger=exchanger;
	}
	
	@Override
	public void run(){
		try {
			System.out.println("线程B中得到线程A的值："+exchanger.exchange("B"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
