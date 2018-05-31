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
 * Wait-Notifyģ�͵�������-������ģ��
 * @author Tao Wenjun
 * @date 2018��5��31��
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
				//����Ϊ�գ���ȴ�
				while(buffer.size()==0){
					BUFFER_LOCK.wait();
				}
				Task task = buffer.poll();
				assert task!=null;
				//�̶�ʱ�䷶Χ�����ѣ�ģ������ȶ��ķ������������
				Thread.sleep(500+(long)(Math.random()*500));
				System.out.println("    consume:"+task.no);
				BUFFER_LOCK.notifyAll();
			}
		}
		
	}
	
	private class ProducerImpl extends AbstractProducer implements Producer,Runnable{

		@Override
		public void produce() throws InterruptedException {
			//������������ģ��������û�����
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
		//����������
		System.out.println("����������");
		for(int i=0;i<2;i++){
			new Thread(model.newRunnableConsumer()).start();
		}
		//����������
		System.out.println("����������");
		for(int j=0;j<4;j++){
			new Thread(model.newRunnableProducer()).start();
		}
	}

}
