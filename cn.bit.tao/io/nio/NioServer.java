package cn.bit.tao.io.nio;

/**
 * NIO Server 
 * @author Tao wenjun
 * @date 2018��5��26��
 */
public class NioServer {
	public static void main(String[] args) {
		new Thread(new NioServerHandle()).start();
	}
}
