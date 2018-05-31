package cn.bit.tao.producer_consumer.model;

/**
 * 生产者消费者模型
 * @author Tao Wenjun
 * @date 2018年5月30日
 */
public interface Model {
	Runnable newRunnableConsumer();
	Runnable newRunnableProducer();
}
