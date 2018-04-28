package cn.tao.exchanger;

import java.util.concurrent.Exchanger;

/**
 *@author  tao wenjun
 *@date 2018��4��28��
 *Exchanger�߳�B
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
			System.out.println("�߳�B�еõ��߳�A��ֵ��"+exchanger.exchange("B"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
