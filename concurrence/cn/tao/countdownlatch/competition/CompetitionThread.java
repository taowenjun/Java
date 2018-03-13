package cn.tao.countdownlatch.competition;

import java.util.concurrent.CountDownLatch;
/*
 * @author tao wenjun
 * 赛跑比赛线程
 */
public class CompetitionThread extends Thread{
	
	private CountDownLatch comingTag;
	private CountDownLatch waitTag;
	private CountDownLatch waitRunTag;
	private CountDownLatch beginTag;
	private CountDownLatch endTag;
	
	public CompetitionThread(CountDownLatch comingTag,CountDownLatch waitTag,
			CountDownLatch waitRunTag,CountDownLatch beginTag,CountDownLatch endTag){
		super();
		this.comingTag = comingTag;
		this.waitTag = waitTag;
		this.waitRunTag = waitRunTag;
		this.beginTag = beginTag;
		this.endTag = endTag;
	}
	
	@Override
	public void run(){
		try{
			System.out.println(this.getName()+" 正向这头走");
			Thread.sleep((int)(Math.random()*10000));
			System.out.println(this.getName()+" 到起点了");
			comingTag.countDown();
			System.out.println(this.getName()+" 等待裁判说准备");
			waitTag.await();
			System.out.println(this.getName()+" 准备起跑");
			Thread.sleep((int)(Math.random()*20000));
			waitRunTag.countDown();
			beginTag.await();
			System.out.println(this.getName()+" 比赛过程");
			Thread.sleep((int)(Math.random()*10000));
			endTag.countDown();
			System.out.println(this.getName()+" 到达终点");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
