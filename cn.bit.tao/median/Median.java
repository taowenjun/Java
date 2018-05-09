package cn.bit.tao.median;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 中位数
 * @author Tao Wenjun
 * @date 2018年5月9日
 * @param <E>
 */
public class Median<E> {
	
	private PriorityQueue<E> minP; //小根堆
	private PriorityQueue<E> maxP; //最大堆
	
	private E m;  //当前中值
	
	public Median(){
		this.minP = new PriorityQueue<>();
		this.maxP = new PriorityQueue<>(11,Collections.reverseOrder());
	}
	
	private int compare(E e,E m){
		Comparable<? super E> cmpr = (Comparable<? super E>)e;
		return cmpr.compareTo(m);
	}
	
	public void add(E e){
		if(m==null){
			m=e; 
			return;
		}
		if(compare(e,m)<=0){
			//小于中值，加入大根堆
			maxP.add(e);
		}else{
			minP.add(e);
		}
		if(minP.size()-maxP.size()>=2){
			maxP.add(this.m);
			this.m=minP.poll();
		}else if(maxP.size()-minP.size()>=2){
			minP.add(this.m);
			this.m=maxP.poll();
		}
	}
	public void addAll(Collection<? extends E> c){
		for(E e:c){
			add(e);
		}
	}
	
	public E getM(){
		return m;
	}
}
