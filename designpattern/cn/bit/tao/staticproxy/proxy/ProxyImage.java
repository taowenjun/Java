package cn.bit.tao.staticproxy.proxy;

import cn.bit.tao.staticproxy.impl.RealImage;
import cn.bit.tao.staticproxy.interfaces.Image;

/*
 * @author Tao wenjun
 * ¥˙¿Ì¿‡
 */
public class ProxyImage implements Image{
	private RealImage realImage;
	private String fileName;
	
	public ProxyImage(String fileName){
		this.fileName=fileName;
	}
	
	@Override
	public void display() {
		if(realImage == null){
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}

}
