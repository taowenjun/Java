package cn.tao.semaphore;

/*
 * @author Tao wenjun
 * ʹ���ź��������߳�
 */
public class SemaThread extends Thread{

	private SemaphoreService service;
	
	public SemaThread(SemaphoreService service,String name){
		super();
		this.service = service;
		this.setName(name);
	}
	
	@Override
	public void run(){
		service.testMethod();
	}
}
