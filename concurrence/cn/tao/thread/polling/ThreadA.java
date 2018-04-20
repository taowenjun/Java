package cn.tao.thread.polling;
/**
 *@author  tao wenjun
 *@date 2018年4月20日
 *
 */

public class ThreadA extends Thread {
	volatile private MyList list;
	
	public ThreadA(MyList list){
	    super();
		this.list = list;
	}
	
	public void run(){
		try{
			for(int i=0;i<10;i++){
				list.add();
				System.out.println("添加了"+(i+1)+"个元素");
				Thread.sleep(800);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
