package cn.bit.tao.producer_consumer.abs;

import cn.bit.tao.producer_consumer.inter.Producer;

/**
 * 消费者抽象类
 * @author Tao Wenjun
 * @date 2018年5月30日
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
