package cn.bit.tao.producer_consumer.inter;

/**
 * 生产者接口
 * @author Tao Wenjun
 * @date 2018年5月30日
 */
public interface Producer {
	
	void produce() throws InterruptedException;
}
