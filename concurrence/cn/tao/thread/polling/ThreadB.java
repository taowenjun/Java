package cn.tao.thread.polling;
/**
 *@author  tao wenjun
 *@date 2018年4月20日
 *
 */

public class ThreadB extends Thread {
	
	volatile private MyList list;
	
	public ThreadB(MyList list){
		super();
		this.list = list;
	}
	
	public void run(){
		try{
			while(true){
				if(list.size()==5){
					System.out.println("==5,线程b准备退出了");
					throw new InterruptedException();
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
