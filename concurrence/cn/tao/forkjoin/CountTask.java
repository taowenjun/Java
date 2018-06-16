package cn.tao.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 *@author  tao wenjun
 *@date 2018��6��16��
 * Fork join Demo
 */

public class CountTask extends RecursiveTask<Integer>{
	
	private static final long serialVersionUID = 1L;
	
	//��ֵ
	private static final int THRESHOLD = 2;
	
	private int start;
	
	private int end;
	
	public CountTask(int start,int end){
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		//�ж������Ƿ��㹻С
		boolean canCompute = (end - start) <= THRESHOLD;
		if(canCompute){
			//���С����ֵ���ͽ�������
			for(int i=start;i<=end;i++){
				sum+=i;
			}
		}else{
			//���������ֵ�����ٽ���������
			int middle = (start+end)/2;
			CountTask leftTask = new CountTask(start,middle);
			CountTask rightTask = new CountTask(middle+1,end);
			//ִ��������
			leftTask.fork();
			rightTask.fork();
			//�ȴ�������ִ���꣬���õ�ִ�н��
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			System.out.println(leftResult);
			System.out.println(rightResult);
			//�ϲ�������
			sum = leftResult + rightResult;
		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountTask task = new CountTask(1,6);
		//ִ������
		Future<Integer> result = forkJoinPool.submit(task);
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
