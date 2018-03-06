package cn.bit.tao.dictionaryorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/*
 * @Author:TaoWenjun
 * @CreateTime:2018/03/06
 * <×ÖµäÅÅÐò>
 */
public class DictionaryOrder1{
	/*
	 * ¸ÄÐ´Collections±È½ÏÆ÷
	 */
	public List<Integer> dictionaryOrder1(List<Integer> list){
		 if(list==null){
			 return list;
		 }
		 Collections.sort(list,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String str1=String.valueOf(o1);
				String str2=String.valueOf(o2);
				if(str1.length()==str2.length()){
					return (int)(o1-o2);
				}else{
					for(int i=0;i<Math.min(str1.length(),str2.length());i++){
						if(str1.charAt(i)!=str2.charAt(i)){
							return str1.charAt(i)-str2.charAt(i);
						}
					}
					return str1.length()-str2.length();
				}				
			}		 
		});
		return list;
	}
	
	//´òÓ¡ListÄÚÈÝ
	public void printList(List<Integer> list){
		Iterator<Integer> iterator=list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	//²âÊÔ×ÖµäÅÅÐò·½·¨
	@Test
	public void testDicOrder(){
		ArrayList<Integer> list=new ArrayList<>();
		int n=16;
		for(int i=0;i<n;i++){
			list.add(i);
		}
		DictionaryOrder1 order=new DictionaryOrder1();
		System.out.println("×ÖµäÅÅÐòÇ°");
		order.printList(list);
		order.dictionaryOrder1(list);
		System.out.println("×ÖµäÅÅÐòºó");
		order.printList(list);
	}
}
