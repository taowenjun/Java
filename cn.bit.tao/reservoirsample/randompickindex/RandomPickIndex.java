package cn.bit.tao.reservoirsample.randompickindex;

import java.util.Random;

/**
 * @author Tao wenjun
 * �������в��Ҹ��������±꣬��ͬ�������±���ֵĸ������
 */
public class RandomPickIndex {
	
	private int[] nums;
	private Random rand;

	public RandomPickIndex(int[] nums){
		this.nums = nums;
		rand = new Random();
	}
	
	/*
	 * ��ˮ�س���
	 */
	public int pick(int target){
		int result=-1;
		int count=1;
		for(int i=0;i<nums.length;i++){
			if(target==nums[i]){
				if(rand.nextInt(count+1)==count){
					result=i;
				}
				count++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		RandomPickIndex pick = new RandomPickIndex(new int[]{1,2,3,3,3,3});
        System.out.println(pick.pick(3));
	}

}
