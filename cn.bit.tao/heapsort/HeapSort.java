package cn.bit.tao.heapsort;

import org.junit.Test;

/*
 * @author Tao wenjun
 * 堆排序
 */
public class HeapSort {

	/*
	 * 堆排序
	 */
	public static void heapSort(int[] array){
		if(array==null||array.length==0){
			return;
		}
		
		buildHeap(array);
		
		for(int i=array.length-1;i>0;i--){
			exchange(array,i,0);
			maxHeap(array, i, 0);
		}
	}
	
	/*
	 * 建立大根堆
	 */
	private static void buildHeap(int[] array){
		if(array==null||array.length==0){
			return;
		}
		int len=array.length;
		for(int i=len/2;i>=0;i--){
			maxHeap(array,len,i);
		}
	}
	
	/*
	 * 调整指定节点，使得该节点及其子节点成为大根堆
	 */
	private static void maxHeap(int[] array,int heapSize,int index){
		int left = 2*index+1;
		int right = 2*index+2;
		
		int largest=index;
		if(left<heapSize&&array[left]>array[largest]){
			largest=left;
		}
		if(right<heapSize&&array[right]>array[largest]){
			largest=right;
		}
		if(index!=largest){
			exchange(array,index,largest);
			maxHeap(array,heapSize,largest);
		}
	}
	
	private static void exchange(int[] array,int i1,int i2){
		int temp=array[i1];
		array[i1]=array[i2];
		array[i2]=temp;
	}
	
	@Test
	public void test(){
		int[] input={2,4,5,1,7,6,3,8};
		HeapSort.heapSort(input);
		for(int i:input){
			System.out.print(i);
			System.out.print(" ");
		}
	}
	
}
