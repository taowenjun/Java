package cn.tao.thread.polling;

import java.util.ArrayList;
import java.util.List;

/**
 *@author  tao wenjun
 *@date 2018Äê4ÔÂ20ÈÕ
 *
 */

public class MyList {
	
	private List<String> list = new ArrayList<>();
	
	public void add(){
		list.add("elements");
	}
	
	public int size(){
		return list.size();
	}
}
