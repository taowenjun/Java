package cn.tao.thread.polling;
/**
 *@author  tao wenjun
 *@date 2018��4��20��
 *�̼߳�ͨ��--��ѯ
 */

public class Run {

	public static void main(String[] args) {
		MyList list = new MyList();
		Thread a = new ThreadA(list);
		a.setName("A");
		Thread b = new ThreadB(list);
		b.setName("B");
        a.start();
        b.start();
	}

}
