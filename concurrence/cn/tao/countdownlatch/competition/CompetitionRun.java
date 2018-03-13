package cn.tao.countdownlatch.competition;

import java.util.concurrent.CountDownLatch;
/*
 * @author tao wenjun
 * 模拟赛跑比赛
 */
public class CompetitionRun {

	public static void main(String[] args) {
		CountDownLatch comingTag = new CountDownLatch(10);
		CountDownLatch waitTag = new CountDownLatch(1);
		CountDownLatch waitRunTag = new CountDownLatch(10);
		CountDownLatch beginTag = new CountDownLatch(1);
		CountDownLatch endTag = new CountDownLatch(10);

		CompetitionThread[] threadArray = new CompetitionThread[10];
		for(int i=0;i<threadArray.length;i++){
			threadArray[i]=new CompetitionThread(comingTag,waitTag,waitRunTag,beginTag,endTag);
			threadArray[i].start();
		}
		try {
		    System.out.println("裁判等待选手到来");
			comingTag.await();
			System.out.println("所有选手到来，巡视5秒");
			Thread.sleep(1000);
			waitTag.countDown();
			System.out.println("各就各位");
			waitRunTag.wait();
			Thread.sleep(500);
			System.out.println("发令枪响");
			beginTag.countDown();
			endTag.await();
			System.out.println("所有运动员到达");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
