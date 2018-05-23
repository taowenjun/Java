package cn.bit.tao.median;

import java.util.Arrays;
import java.util.List;

/**
 * 测试中位数程序
 * @author Tao Wenjun
 * @date 2018年5月9日
 */

public class TestMedian {

	public static void main(String[] args) {
		Median<Integer> median = new Median<>();
		List<Integer> list = Arrays.asList(new Integer[]{
				34,90,67,45,1,4,5,6,7,9,10});
		median.addAll(list);
		System.out.println(median.getM());
		
		MedianOfTwoSortedArray medianOfTA=new MedianOfTwoSortedArray();
		System.out.println(medianOfTA.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
	}

}
