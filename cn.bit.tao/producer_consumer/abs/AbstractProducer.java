package cn.bit.tao.producer_consumer.abs;

import cn.bit.tao.producer_consumer.inter.Producer;

/**
 * �����߳�����
 * @author Tao Wenjun
 * @date 2018��5��30��
 */
public abstract class AbstractProducer implements Producer, Runnable {
	
	@Override
	public void run() {
		while(true){
			try {
				produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
