package cn.tao.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *@author  tao wenjun
 *@date 2018��4��29��
 *Future Demo
 */

public class TestFuture {

	public static void main(String[] args) throws Exception, ExecutionException {
		String data = "query";
		
		FutureTask<String> task1 = new FutureTask<>(new UseFuture(data+"1"));
		FutureTask<String> task2 = new FutureTask<>(new UseFuture(data+"2"));
		
		ExecutorService executor =  Executors.newFixedThreadPool(2);
		
		executor.submit(task1);
		executor.submit(task2);
		
		
		System.out.println("task1 is done:"+task1.isDone());
		System.out.println("task2 is done:"+task2.isDone());
		
		System.out.println("�������");
		
		try {
			System.out.println("��������");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("task1 is done:"+task1.isDone());
		System.out.println("task2 is done:"+task2.isDone());
		
		System.out.println("task1���ݣ�"+task1.get());
		System.out.println("task2���ݣ�"+task2.get());
	}

}
