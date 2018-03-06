package cn.bit.tao.dictionaryorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.junit.Test;
/*
 * @Author:TaoWenjun
 * @CreateTime:2018/03/06
 * <×ÖµäÅÅÐò>
 */
public class DictionaryOrder2 {
	//×ÔÈ»ÅÅÐò
	public void dictionaryOrder(){
		int n=16;
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<n;i++){
			list.add(String.valueOf((i+1)));
		}
		System.out.println("×ÖµäÅÅÐòÇ°");
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		Collections.sort(list);
		System.out.println("×ÖµäÅÅÐòºó");
		Iterator<String> iterator2=list.iterator();
		while(iterator2.hasNext()){
			System.out.println(iterator2.next());
		}
	}
	
	@Test
	public void testDicOrder(){
		DictionaryOrder2 order=new DictionaryOrder2();
		order.dictionaryOrder();
	}
}
