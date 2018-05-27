package cn.bit.tao.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIO客户端
 * @author Tao Wenjun
 * @date 2018年5月26日
 */
public class NIOClient {

	private Selector selector;
	
	/**
	 * 获得一个Socket通道，并对该通道做一些初始化的工作
	 * @param ip：连接服务器的IP
	 * @param port：连接服务器的端口
	 * @throws IOException
	 */
	public void initClient(String ip,int port) throws IOException{
		//获得一个Socket通道
		SocketChannel channel = SocketChannel.open();
		//设置通道为非阻塞
		channel.configureBlocking(false);
		//获得一个通道管理器
		this.selector = Selector.open();
		//完成连接
		channel.connect(new InetSocketAddress(ip, port));
		//将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件
		channel.register(selector, SelectionKey.OP_CONNECT);
	}
	
	/**
	 * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
	 * @throws IOException
	 */
	public void listen() throws IOException{
		//轮询访问selector
		while(true){
			selector.select();
			//获取selector中选中的项的迭代器
			Iterator ite = this.selector.selectedKeys().iterator();
			while(ite.hasNext()){
				SelectionKey key = (SelectionKey) ite.next();
				ite.remove();
				//连接事件发生
				if(key.isConnectable()){
					SocketChannel channel = (SocketChannel) key.channel();
					//如果正在连接，则完成连接
					if(channel.isConnectionPending()){
						channel.finishConnect();
					}
					channel.configureBlocking(false);
					channel.write(ByteBuffer.wrap(new String("query").getBytes()));
					channel.register(selector, SelectionKey.OP_READ);
				}else if(key.isReadable()){
					read(key);
				}
			}
		}
	}
	
	/**
	 * 处理读取服务端发来的信息的事件
	 * @param key
	 * @throws IOException
	 */
	public void read(SelectionKey key) throws IOException{
		SocketChannel channel = (SocketChannel) key.channel();
		//创建读取的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(100);
		channel.read(buffer);
		byte[] data = buffer.array();
		String msg = new String(data).trim();
		System.out.println("客户端端收到信息："+msg);
		
	}
	
	public static void main(String[] args) {
		NIOClient client = new NIOClient(); 
        try {
			client.initClient("localhost",8989);
			client.listen(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
