package cn.bit.tao.io.nio;

/**
 * NIO Server 
 * @author Tao wenjun
 * @date 2018Äê5ÔÂ26ÈÕ
 */
public class NioServer {
	public static void main(String[] args) {
		new Thread(new NioServerHandle()).start();
	}
}
