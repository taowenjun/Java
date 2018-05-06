package cn.bit.tao.topk;

import java.util.Arrays;

/**
 * ²âÊÔ TopK
 * @author Tao Wenjun
 * @date 2018Äê5ÔÂ6ÈÕ
 */
public class TestTopK {

	public static void main(String[] args) {
		TopK<Integer> top5 = new TopK<>(5);
		top5.addAll(Arrays.asList(new Integer[]{100,1,2,5,6,7,34,9,3,4,5,8,23,21,90,1,0}));
		System.out.println(Arrays.toString(top5.toArray(new Integer[0])));
		System.out.println(top5.getKth());
	}

}
