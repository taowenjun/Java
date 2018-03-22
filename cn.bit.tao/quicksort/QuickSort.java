package cn.bit.tao.quicksort;

import org.junit.Test;

/*
 * @author Tao wenjun
 * 快速排序
 */
public class QuickSort {
	
	/*
	 * 快排
	 * 首先获取一次快排的下标，
	 * 再分别对下标两边进行快速排序
	 */
	public static void quickSort(int[] input,int begin,int end){
		if(begin>=end)
			return;
		int index=partition(input,begin,end);
		quickSort(input,begin,index-1);
		quickSort(input,index+1,end);
	}
	/*
	 * 一次快速排序
	 * @return 分片的间隔点
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
	
	//交换数组中两个位置的元素
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
