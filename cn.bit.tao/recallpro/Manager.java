package cn.bit.tao.recallpro;

/**
 * 该类模拟总经理
 * @author Tao Wenjun
 * @date 2018年7月13日
 */
public class Manager {
	
	public Manager(){
		
	}
	
	/**
	 * 给员工布置任务方法
	 * @param personnel：干活的员工
	 * @param task：具体任务
	 */
	public void assignTask(Personnel personnel,String task){
		System.out.println("总经理：给员工布置任务");
		personnel.doSomething(this, task);
	}
	
	/**
	 * 总经理的联系方式
	 * @param result
	 */
	public void phoneCall(String result){
		System.out.print(" 总经理：接到电话，被告知员工的工作结果：");
		System.out.println(result);
	}
}
