package cn.bit.tao.producer_consumer.inter;

/**
 * 消费者接口 
 * @author Tao Wenjun
 * @date 2018年5月30日
 */
public interface Consumer {
	
	void consume() throws InterruptedException;
}
