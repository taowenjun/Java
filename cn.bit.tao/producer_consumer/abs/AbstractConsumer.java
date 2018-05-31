package cn.bit.tao.producer_consumer.abs;

import cn.bit.tao.producer_consumer.inter.Consumer;

/**
 * 消费者抽象类
 * @author Tao Wenjun
 * @date 2018年5月30日
 */

public abstract class AbstractConsumer implements Consumer, Runnable {

	@Override
	public void run() {
		while(true){
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}

}
