package cn.tao.countdownlatch.competition;

import java.util.concurrent.CountDownLatch;
/*
 * @author tao wenjun
 * ���ܱ����߳�
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
			System.out.println(this.getName()+" ������ͷ��");
			Thread.sleep((int)(Math.random()*10000));
			System.out.println(this.getName()+" �������");
			comingTag.countDown();
			System.out.println(this.getName()+" �ȴ�����˵׼��");
			waitTag.await();
			System.out.println(this.getName()+" ׼������");
			Thread.sleep((int)(Math.random()*20000));
			waitRunTag.countDown();
			beginTag.await();
			System.out.println(this.getName()+" ��������");
			Thread.sleep((int)(Math.random()*10000));
			endTag.countDown();
			System.out.println(this.getName()+" �����յ�");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
