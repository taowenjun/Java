package cn.tao.producerandconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private BlockingQueue<Data> queue;
	
	public Consumer(BlockingQueue queue){
		this.queue=queue;
	}

	private static Random r=new Random();
	
	@Override
	public void run() {
		while(true){
			try{
				Data data=this.queue.take();
				Thread.sleep(r.nextInt(1000));
				System.out.println("当前消费线程："+Thread.currentThread().getName()+",消费成功,消费数据为id:"+data.getId());
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
