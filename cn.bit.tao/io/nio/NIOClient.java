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
 * NIO�ͻ���
 * @author Tao Wenjun
 * @date 2018��5��26��
 */
public class NIOClient {

	private Selector selector;
	
	/**
	 * ���һ��Socketͨ�������Ը�ͨ����һЩ��ʼ���Ĺ���
	 * @param ip�����ӷ�������IP
	 * @param port�����ӷ������Ķ˿�
	 * @throws IOException
	 */
	public void initClient(String ip,int port) throws IOException{
		//���һ��Socketͨ��
		SocketChannel channel = SocketChannel.open();
		//����ͨ��Ϊ������
		channel.configureBlocking(false);
		//���һ��ͨ��������
		this.selector = Selector.open();
		//�������
		channel.connect(new InetSocketAddress(ip, port));
		//��ͨ���������͸�ͨ���󶨣���Ϊ��ͨ��ע��SelectionKey.OP_CONNECT�¼�
		channel.register(selector, SelectionKey.OP_CONNECT);
	}
	
	/**
	 * ������ѯ�ķ�ʽ����selector���Ƿ�����Ҫ������¼�������У�����д���
	 * @throws IOException
	 */
	public void listen() throws IOException{
		//��ѯ����selector
		while(true){
			selector.select();
			//��ȡselector��ѡ�е���ĵ�����
			Iterator ite = this.selector.selectedKeys().iterator();
			while(ite.hasNext()){
				SelectionKey key = (SelectionKey) ite.next();
				ite.remove();
				//�����¼�����
				if(key.isConnectable()){
					SocketChannel channel = (SocketChannel) key.channel();
					//����������ӣ����������
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
	 * �����ȡ����˷�������Ϣ���¼�
	 * @param key
	 * @throws IOException
	 */
	public void read(SelectionKey key) throws IOException{
		SocketChannel channel = (SocketChannel) key.channel();
		//������ȡ�Ļ�����
		ByteBuffer buffer = ByteBuffer.allocate(100);
		channel.read(buffer);
		byte[] data = buffer.array();
		String msg = new String(data).trim();
		System.out.println("�ͻ��˶��յ���Ϣ��"+msg);
		
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
