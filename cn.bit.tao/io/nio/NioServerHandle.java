package cn.bit.tao.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.sql.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO Server处理线程
 * @author Tao wenjun
 * @date 2018年5月26日
 */
public class NioServerHandle implements Runnable{
	
	ServerSocketChannel serverSocketChannel = null;
	
	Selector selector = null;
	
	boolean stop = false;
	
	/**
	 * 初始化注册
	 */
	public NioServerHandle(){
		try {
			//获取ServerSocketChannel对象
			serverSocketChannel = ServerSocketChannel.open();
			//绑定IP
			serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8989));
		    //设置为非阻塞
			serverSocketChannel.configureBlocking(false);
			//获取Selector
			selector = Selector.open();
			//将管道注册到多路复用器selector上
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@Override
	public void run() {
		while(!stop){
			try {
				//设置超时时间
				selector.select(1000);
				//获取所有key
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				//遍历
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey selectionKey = null;
				while(it.hasNext()){
					selectionKey = it.next();
					//获取到就绪数组进行操作，并移除
					it.remove();
					try {
						handle(selectionKey);
					} catch (Exception e) {
						selectionKey.cancel();
						selectionKey.channel().close();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * 处理key
	 * @param key
	 * @throws Exception
	 */
	public void handle(SelectionKey key) throws Exception{
		if(key.isValid()){
			//accept
			if(key.isAcceptable()){
				//获取ServerSocketChannel
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				//接受请求
				SocketChannel sc = ssc.accept();
				//设置为非阻塞
				sc.configureBlocking(false);
				//注册到多路复用器
				sc.register(selector, SelectionKey.OP_READ);
			}
			//read data
			if(key.isReadable()){
				//得到SocketChannel
				SocketChannel sc = (SocketChannel) key.channel();
				//设置字节缓冲区
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				//将通道的数据读取码流
				int readByte = sc.read(readBuffer);
				//对于大于0的情况进行编解码
				if(readByte>0){
					//将当前的缓冲区的limit设置为0，让后面进行读取
					readBuffer.flip();
					//根据缓冲区的可读大小设置字节数组
					byte[] bytes = new byte[readBuffer.remaining()];
					//get将读取的数据放入字节数组
					readBuffer.get(bytes);
					//将字节数组按照UTF-8的格式输出到body
					String body = new String(bytes,"UTF-8");
					System.out.println("The time server receive order:"+body);
					String currentTime = "query".equals(body)?new Date(System.currentTimeMillis()).toString():"No";
				    //进行输出操作
					doWrite(sc,currentTime);
				}
			}
			//write data
			if(key.isWritable()){
				
			}
			//connect
			if(key.isConnectable()){
				
			}
		}
	}
	
	/**
	 * 将数据返回给客户端
	 * @param sc ：写回的Channel
	 * @param currentTime：写回的内容
	 * @throws Exception
	 */
	public void doWrite(SocketChannel sc,String currentTime) throws Exception{
		if(currentTime!=null&&currentTime.trim().length()>0){
			//转换为字节数组，放到缓冲区
			byte[] bytes = currentTime.getBytes();
			ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
			byteBuffer.put(bytes);
			byteBuffer.flip();
			sc.write(byteBuffer);
		}
	}
}
