package cn.bit.tao.producer_consumer.model;

/**
 * ������������ģ��
 * @author Tao Wenjun
 * @date 2018��5��30��
 */
public interface Model {
	Runnable newRunnableConsumer();
	Runnable newRunnableProducer();
}
