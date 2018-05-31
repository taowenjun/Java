/**
 * 
 */
package cn.bit.tao.producer_consumer.bqmodel;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

import cn.bit.tao.producer_consumer.abs.AbstractConsumer;
import cn.bit.tao.producer_consumer.abs.AbstractProducer;
import cn.bit.tao.producer_consumer.inter.Consumer;
import cn.bit.tao.producer_consumer.inter.Producer;
import cn.bit.tao.producer_consumer.model.Model;
import cn.bit.tao.producer_consumer.task.Task;

/**
 * ʹ��BlockingQueueʵ����Ϣ����
 * @author Tao Wenjun
 * @date 2018��5��30��
 */
public class BlockingQueueModel implements Model {

	private final BlockingDeque<Task> queue;
	
	private final AtomicInteger increTaskNo = new AtomicInteger(0);
	
	public BlockingQueueModel(int cap){
		
		this.queue = new LinkedBlockingDeque<>(cap);
	}
	
	@Override
	public Runnable newRunnableConsumer() {
		
		return new ConsumerImpl();
	}

	@Override
	public Runnable newRunnableProducer() {
		
		return new ProducerImpl();
	}

	/**
	 * ������ʵ����
	 */
	private class ConsumerImpl extends AbstractConsumer implements Consumer,Runnable{

		@Override
		public void consume() throws InterruptedException {
			Task task = queue.take();
			//�̶�ʱ�䷶Χ������
			Thread.sleep(500+(long)(Math.random()*500));
			System.out.println(" 		 consume:"+task.no);
		}
	}
	
	/**
	 * ������ʵ����
	 */
	private class ProducerImpl extends AbstractProducer implements Producer,Runnable{

		@Override
		public void produce() throws InterruptedException {
			//������������ģ��������û�����
			Thread.sleep((long)(Math.random()*1000));
			Task task = new Task(increTaskNo.getAndIncrement());
			queue.put(task);
			System.out.println("produce:"+task.no);
		}	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Model model = new BlockingQueueModel(3);
		//����������
		System.out.println("����������");
		for(int i=0;i<2;i++){
			new Thread(model.newRunnableConsumer()).start();
		}
		//����������
		System.out.println("����������");
		for(int j=0;j<5;j++){
			new Thread(model.newRunnableProducer()).start();
		}
	}
}


