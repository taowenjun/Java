package cn.tao.thread.waitnotify;
/**
 *@author  tao wenjun
 *@date 2018��4��20��
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
			synchronized(list){
				for(int i=0;i<10;i++){
					list.add();
					if(list.size()==5){
						list.notify();
						System.out.println(this.getName()+"�Ѿ�������֪ͨ��");
					}
					System.out.println("������"+(i+1)+"��Ԫ��");
					Thread.sleep(800);
				}
				
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}