package cn.bit.tao.callback;

/**
 * 测试回调函数
 * @author Tao Wenjun
 * @date 2018年7月13日
 */
public class Main {

	public static void main(String[] args) {
		
		String task = "整理文件";
		
		Manager manager = new Manager();
		//给员工布置任务
		manager.assignTask(new Personnel(), task);
		
	}

}
