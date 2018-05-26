package cn.bit.tao.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * BIO�ͻ���
 * �����˷�����Ϣ���������������ص���Ϣ��ӡ
 * @author Tao wenjun
 * @date 2018��5��25��
 */
public class BioClient {

	private static Socket socket;

	public static void main(String[] args) {
		OutputStream outputStream = null;
		InputStream inputStream = null;
		try {
			socket = new Socket("10.108.20.181",8889);
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			outputStream.write("query time".getBytes("utf-8"));
			System.out.println("�ͻ��˷�����һ����ѯʱ������");
			byte[] b = new byte[1024];
			int read = inputStream.read(b);
			System.out.println("�ͻ��˻�ȡ����Ӧ");
			System.out.println(new String(b,0,read));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				outputStream.close();
				inputStream.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		

	}

}
