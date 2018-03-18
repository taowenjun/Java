package cn.tao.semaphore;

/*
 * @author Tao wenjun
 * 运行信号量服务
 */
public class SemaphoreRun {

	public static void main(String[] args) {
		SemaphoreService service = new SemaphoreService(4);
//		SemaThread a = new SemaThread(service,"A");
//		SemaThread b = new SemaThread(service,"B");
//		SemaThread c = new SemaThread(service,"C");
//		
//		a.start();
//		b.start();
//		c.start();
		SemaThread[] a = new SemaThread[10];
		for(int i=0;i<10;i++){
			a[i] = new SemaThread(service,"A"+i);
			a[i].start();
		}
	}

}
