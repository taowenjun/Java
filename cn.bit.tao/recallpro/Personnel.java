package cn.bit.tao.recallpro;

/**
 * 该类模拟员工类
 * @author Tao Wenjun
 * @date 2018年7月13日
 */
public class Personnel {
	
	/**
	 * 干活的方法
	 * @param manager：布置任务的经理
	 * @param task：布置的任务
	 */
	public void doSomething(Manager manager,String task){
		
		//总经理通过调用Personnel的该方法告诉员工干什么
		System.out.println("      员工：总经理要我做"+task);
		
		//干活
		System.out.println("      员工：开始干活");
		try {
			System.out.println("      员工：干活ing。。。");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("      员工：活干完了");
		String result = "做完了";
		System.out.println("      员工：打电话给总经理："+task +" "+ result);
		//当事情做完了就通过总经理公布的phoneCall方法通知总经理结果
		manager.phoneCall(task +" "+ result);
	}
}
