package cn.tao.exchanger;

import java.util.concurrent.Exchanger;

/**
 *@author  tao wenjun
 *@date 2018��4��28��
 *Exchanger�߳�A
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
			System.out.println("�߳�A�еõ��߳�B��ֵ��"+exchanger.exchange("A"));
			System.out.println("A end!");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
