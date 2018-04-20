package cn.tao.thread.waitnotify;
/**
 *@author  tao wenjun
 *@date 2018年4月20日
 *线程间通信--wait/notify
 */

public class Run {

	public static void main(String[] args) {
		MyList list = new MyList();
		Thread a = new ThreadA(list);
		a.setName("A");
		Thread b = new ThreadB(list);
		b.setName("B");
        b.start();
        try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        a.start();
	}

}
