package cn.tao.thread.waitnotify;

import java.util.ArrayList;
import java.util.List;

/**
 *@author  tao wenjun
 *@date 2018��4��20��
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
