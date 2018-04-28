package cn.tao.exchanger;

import java.util.concurrent.Exchanger;

/**
 *@author  tao wenjun
 *@date 2018年4月28日
 *Exchanger线程A
 */

public class ThreadA extends Thread {
	
	private Exchanger<String> exchanger;
	
	public ThreadA(Exchanger<String> exchanger){
		super();
		this.exchanger=exchanger;
	}
	
	@Override
	public void run(){
		try{
			System.out.println("线程A中得到线程B的值："+exchanger.exchange("A"));
			System.out.println("A end!");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
