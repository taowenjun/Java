package cn.tao.thread.syn;
/**
 *@author  tao wenjun
 *@date 2018��4��20��
 *�̼߳�ͨ�ŷ�ʽ�������ڴ�
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
