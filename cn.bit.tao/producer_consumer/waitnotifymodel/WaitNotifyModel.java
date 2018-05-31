package cn.bit.tao.producer_consumer.waitnotifymodel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

import cn.bit.tao.producer_consumer.abs.AbstractConsumer;
import cn.bit.tao.producer_consumer.abs.AbstractProducer;
import cn.bit.tao.producer_consumer.inter.Consumer;
import cn.bit.tao.producer_consumer.inter.Producer;
import cn.bit.tao.producer_consumer.model.Model;
import cn.bit.tao.producer_consumer.task.Task;

/**
 * Wait-Notify模型的生产者-消费者模型
 * @author Tao Wenjun
 * @date 2018年5月31日
 */
public class WaitNotifyModel implements Model{

	private final Object BUFFER_LOCK = new Object();
	private final Queue<Task> buffer = new LinkedList<>();
	private final int cap;
	private final AtomicInteger increTaskNo = new AtomicInteger(0);
	
	public WaitNotifyModel(int cap){
		this.cap = cap;
	}

	@Override
	public Runnable newRunnableConsumer() {
		return new ConsumerImpl();
	}

	@Override
	public Runnable newRunnableProducer() {
		return new ProducerImpl();
	}
	
	private class ConsumerImpl extends AbstractConsumer implements Consumer,Runnable{

		@Override
		public void consume() throws InterruptedException {
			synchronized (BUFFER_LOCK) {
				//队列为空，则等待
				while(buffer.size()==0){
					BUFFER_LOCK.wait();
				}
				Task task = buffer.poll();
				assert task!=null;
				//固定时间范围的消费，模拟相对稳定的服务器处理过程
				Thread.sleep(500+(long)(Math.random()*500));
				System.out.println("    consume:"+task.no);
				BUFFER_LOCK.notifyAll();
			}
		}
		
	}
	
	private class ProducerImpl extends AbstractProducer implements Producer,Runnable{

		@Override
		public void produce() throws InterruptedException {
			//不定期生产，模拟随机的用户请求
			Thread.sleep((long)(Math.random()*1000));
			synchronized(BUFFER_LOCK){
				while(buffer.size()==cap){
					BUFFER_LOCK.wait();
				}
				Task task = new Task(increTaskNo.getAndIncrement());
				buffer.offer(task);
				System.out.println("produce:"+task.no);
				BUFFER_LOCK.notifyAll();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Model model = new WaitNotifyModel(3);
		//开启消费者
		System.out.println("开启消费者");
		for(int i=0;i<2;i++){
			new Thread(model.newRunnableConsumer()).start();
		}
		//开启生产者
		System.out.println("开启生产者");
		for(int j=0;j<4;j++){
			new Thread(model.newRunnableProducer()).start();
		}
	}

}
