package cn.bit.tao.staticproxy;

import cn.bit.tao.staticproxy.interfaces.Image;
import cn.bit.tao.staticproxy.proxy.ProxyImage;
/*
 * @author Tao wenjun
 * 设计模式demo
 */
public class ProxyPatternDemo {

	public static void main(String[] args) {
		Image image=new ProxyImage("test_10mb.jpg");
		//图像将从磁盘加载
		image.display();
		
		System.out.println();
		//图像无法从磁盘加载
		image.display();
	}
}
