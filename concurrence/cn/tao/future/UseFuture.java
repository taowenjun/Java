package cn.tao.future;

import java.util.concurrent.Callable;

/**
 *@author  tao wenjun
 *@date 2018��4��29��
 * Callableʵ����
 */

public class UseFuture implements Callable<String>{

	private String data;
	
	public UseFuture(String data){
		this.data=data;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(5000);
		String result = data+"������ɣ�";
		return result;
	}

}
