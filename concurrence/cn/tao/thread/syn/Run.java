package cn.tao.thread.syn;
/**
 *@author  tao wenjun
 *@date 2018年4月20日
 *线程间通信方式：共享内存
 */

public class Run {

	public static void main(String[] args) {
		MyObject object = new MyObject();
		Thread threadA = new ThreadA(object);
		Thread threadB = new ThreadB(object);
		
		threadA.start();
		threadB.start();
	}

}
