package cn.tao.countdownlatch.competition;

import java.util.concurrent.CountDownLatch;
/*
 * @author tao wenjun
 * ģ�����ܱ���
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
		    System.out.println("���еȴ�ѡ�ֵ���");
			comingTag.await();
			System.out.println("����ѡ�ֵ�����Ѳ��5��");
			Thread.sleep(1000);
			waitTag.countDown();
			System.out.println("���͸�λ");
			waitRunTag.wait();
			Thread.sleep(500);
			System.out.println("����ǹ��");
			beginTag.countDown();
			endTag.await();
			System.out.println("�����˶�Ա����");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
