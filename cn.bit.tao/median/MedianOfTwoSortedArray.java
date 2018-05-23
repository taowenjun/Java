package cn.bit.tao.median;

import java.util.PriorityQueue;

/**
 * 求两个有序数组的中位数：PriorityQueue实现
 * @author Administrator
 * @date 2018年5月23日
 */
public class MedianOfTwoSortedArray {
	
	 /**
	  * 求两个有序数组的中位数
	  * @param nums1
	  * @param nums2
	  * @return 中位数
	  */
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int len = nums1.length+nums2.length;
	        int count=len/2+1;
	        
	        PriorityQueue<Integer> pQ=new PriorityQueue<Integer>(count);
	        for(int i:nums1){
	            pQ.add(i);
	            if(pQ.size()>count){
	                pQ.poll();
	            }
	        }
	        
	         for(int i:nums2){
	            pQ.add(i);
	            if(pQ.size()>count){
	                pQ.poll();
	            }
	        }
	        
	        if(len%2!=0){
	            return (double)pQ.peek();
	        }else{
	            int i1=pQ.poll();
	            int i2=pQ.poll();
	            return (i1+i2)/(2.0);
	        }
	        
	    }

}
