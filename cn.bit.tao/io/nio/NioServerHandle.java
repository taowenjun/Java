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
 * NIO Server�����߳�
 * @author Tao wenjun
 * @date 2018��5��26��
 */
public class NioServerHandle implements Runnable{
	
	ServerSocketChannel serverSocketChannel = null;
	
	Selector selector = null;
	
	boolean stop = false;
	
	/**
	 * ��ʼ��ע��
	 */
	public NioServerHandle(){
		try {
			//��ȡServerSocketChannel����
			serverSocketChannel = ServerSocketChannel.open();
			//��IP
			serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8989));
		    //����Ϊ������
			serverSocketChannel.configureBlocking(false);
			//��ȡSelector
			selector = Selector.open();
			//���ܵ�ע�ᵽ��·������selector��
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
				//���ó�ʱʱ��
				selector.select(1000);
				//��ȡ����key
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				//����
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey selectionKey = null;
				while(it.hasNext()){
					selectionKey = it.next();
					//��ȡ������������в��������Ƴ�
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
	 * ����key
	 * @param key
	 * @throws Exception
	 */
	public void handle(SelectionKey key) throws Exception{
		if(key.isValid()){
			//accept
			if(key.isAcceptable()){
				//��ȡServerSocketChannel
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				//��������
				SocketChannel sc = ssc.accept();
				//����Ϊ������
				sc.configureBlocking(false);
				//ע�ᵽ��·������
				sc.register(selector, SelectionKey.OP_READ);
			}
			//read data
			if(key.isReadable()){
				//�õ�SocketChannel
				SocketChannel sc = (SocketChannel) key.channel();
				//�����ֽڻ�����
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				//��ͨ�������ݶ�ȡ����
				int readByte = sc.read(readBuffer);
				//���ڴ���0��������б����
				if(readByte>0){
					//����ǰ�Ļ�������limit����Ϊ0���ú�����ж�ȡ
					readBuffer.flip();
					//���ݻ������Ŀɶ���С�����ֽ�����
					byte[] bytes = new byte[readBuffer.remaining()];
					//get����ȡ�����ݷ����ֽ�����
					readBuffer.get(bytes);
					//���ֽ����鰴��UTF-8�ĸ�ʽ�����body
					String body = new String(bytes,"UTF-8");
					System.out.println("The time server receive order:"+body);
					String currentTime = "query".equals(body)?new Date(System.currentTimeMillis()).toString():"No";
				    //�����������
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
	 * �����ݷ��ظ��ͻ���
	 * @param sc ��д�ص�Channel
	 * @param currentTime��д�ص�����
	 * @throws Exception
	 */
	public void doWrite(SocketChannel sc,String currentTime) throws Exception{
		if(currentTime!=null&&currentTime.trim().length()>0){
			//ת��Ϊ�ֽ����飬�ŵ�������
			byte[] bytes = currentTime.getBytes();
			ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
			byteBuffer.put(bytes);
			byteBuffer.flip();
			sc.write(byteBuffer);
		}
	}
}
