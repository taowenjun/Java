package cn.tao.semaphore;

/*
 * @author Tao wenjun
 * 使用信号量服务线程
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
