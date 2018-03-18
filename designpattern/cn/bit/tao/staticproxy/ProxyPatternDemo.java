package cn.bit.tao.staticproxy;

import cn.bit.tao.staticproxy.interfaces.Image;
import cn.bit.tao.staticproxy.proxy.ProxyImage;
/*
 * @author Tao wenjun
 * ���ģʽdemo
 */
public class ProxyPatternDemo {

	public static void main(String[] args) {
		Image image=new ProxyImage("test_10mb.jpg");
		//ͼ�񽫴Ӵ��̼���
		image.display();
		
		System.out.println();
		//ͼ���޷��Ӵ��̼���
		image.display();
	}
}
