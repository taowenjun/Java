package cn.bit.tao.producer_consumer.lockconditionmodel2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.bit.tao.producer_consumer.abs.AbstractConsumer;
import cn.bit.tao.producer_consumer.abs.AbstractProducer;
import cn.bit.tao.producer_consumer.inter.Consumer;
import cn.bit.tao.producer_consumer.inter.Producer;
import cn.bit.tao.producer_consumer.model.Model;
import cn.bit.tao.producer_consumer.task.Task;
import cn.bit.tao.producer_consumer.waitnotifymodel.WaitNotifyModel;

/**
 * 改进版的Lock-Condition模式的生产者消费者模式
 * @author Tao Wenjun
 * @date 2018年5月31日
 */
public class LockConditionModel2 implements Model {

    private final Lock CONSUME_LOCK = new ReentrantLock();
    private final Condition NOT_EMPTY = CONSUME_LOCK.newCondition();
    private final Lock PRODUCE_LOCK = new ReentrantLock();
    private final Condition NOT_FULL = PRODUCE_LOCK.newCondition();
    private final Buffer<Task> buffer = new Buffer<>();
    private final int cap;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);
    private AtomicInteger bufLen = new AtomicInteger(0);
    
    public LockConditionModel2(int cap) {
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
			int newBufSize = -1;
		      CONSUME_LOCK.lockInterruptibly();
		      try {
		        while (bufLen.get() == 0) {
		          System.out.println("buffer is empty...");
		          NOT_EMPTY.await();
		        }
		        Task task = buffer.poll();
		        newBufSize = bufLen.decrementAndGet();
		        assert task != null;
		        // 固定时间范围的消费，模拟相对稳定的服务器处理过程
		        Thread.sleep(500 + (long) (Math.random() * 500));
		        System.out.println("consume: " + task.no);
		        if (newBufSize > 0) {
		          NOT_EMPTY.signalAll();
		        }
		      } finally {
		        CONSUME_LOCK.unlock();
		      }
		      if (newBufSize < cap) {
		        PRODUCE_LOCK.lockInterruptibly();
		        try {
		          NOT_FULL.signalAll();
		        } finally {
		          PRODUCE_LOCK.unlock();
		        }
		      }
		    
		}		
	}
	
	private class ProducerImpl extends AbstractProducer implements Producer,Runnable{

		@Override
		public void produce() throws InterruptedException {
			//不定期生产，模拟随机的用户请求
			Thread.sleep((long)(Math.random()*1000));
			int newBufSize = -1;
			PRODUCE_LOCK.lockInterruptibly();
			try{
				while(bufLen.get()==cap){
					System.out.println("buffer is full...");
					NOT_FULL.await();
				}
				Task task = new Task(increTaskNo.getAndIncrement());
				buffer.offer(task);
				newBufSize=bufLen.incrementAndGet();
				System.out.println("produce:"+task.no);
				if(newBufSize<cap){
					NOT_FULL.signal();
				}
			}finally{
				PRODUCE_LOCK.unlock();
			}
			if (newBufSize > 0) {
			    CONSUME_LOCK.lockInterruptibly();
			    try {
			        NOT_EMPTY.signalAll();
			    } finally {
			        CONSUME_LOCK.unlock();
			    }
			}
		}		
	}
	
	private static class Buffer<E> {
	    private Node head;
	    private Node tail;
	    Buffer() {
	      // dummy node
	      head = tail = new Node(null);
	    }
	    public void offer(E e) {
	      tail.next = new Node(e);
	      tail = tail.next;
	    }
	    public E poll() {
	      head = head.next;
	      E e = head.item;
	      head.item = null;
	      return e;
	    }
	    private class Node {
	      E item;
	      Node next;
	      Node(E item) {
	        this.item = item;
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
