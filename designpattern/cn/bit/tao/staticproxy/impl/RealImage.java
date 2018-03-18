package cn.bit.tao.staticproxy.impl;

import cn.bit.tao.staticproxy.interfaces.Image;
/*
 * @author Tao wenjun
 * 被代理者类
 */
public class RealImage implements Image{
	
	private String fileName;
	
	public RealImage(String fileName){
		this.fileName=fileName;
		loadFromDisk(fileName);
	}
	
	private void loadFromDisk(String fileName) {
		System.out.println("Loading "+fileName);
	}

	@Override
	public void display() {
		System.out.println("Displaying "+fileName);
	}

}
