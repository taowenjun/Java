package cn.bit.tao.quicksort;

import org.junit.Test;

/*
 * @author Tao wenjun
 * ��������
 */
public class QuickSort {
	
	/*
	 * ����
	 * ���Ȼ�ȡһ�ο��ŵ��±꣬
	 * �ٷֱ���±����߽��п�������
	 */
	public static void quickSort(int[] input,int begin,int end){
		if(begin>=end)
			return;
		int index=partition(input,begin,end);
		quickSort(input,begin,index-1);
		quickSort(input,index+1,end);
	}
	/*
	 * һ�ο�������
	 * @return ��Ƭ�ļ����
	 */
	private static int partition(int[] input,int begin,int end){
		int x=input[begin];
		int smallIndex=begin;
		int bigIndex=begin;
		while(++bigIndex<=end){
			if(input[bigIndex]>=x)
				continue;
			else{
				smallIndex++;
				if(smallIndex!=bigIndex)
					swap(input,smallIndex,bigIndex);
			}
		}
		swap(input,begin,smallIndex);
		return smallIndex;
	}
	
	//��������������λ�õ�Ԫ��
	private static void swap(int[] input,int index1,int index2){
		int temp=input[index1];
		input[index1]=input[index2];
		input[index2]=temp;
	}
	
	@Test
	public void test(){
		int[] input={2,4,5,1,7,6,3,8};
		QuickSort.quickSort(input, 0, 7);
		for(int i:input){
			System.out.print(i);
			System.out.print(" ");
		}
	}
}
