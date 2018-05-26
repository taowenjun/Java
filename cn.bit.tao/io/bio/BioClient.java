package cn.bit.tao.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * BIO客户端
 * 向服务端发送信息，并将服务器返回的信息打印
 * @author Tao wenjun
 * @date 2018年5月25日
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
			System.out.println("客户端发送了一个查询时间命令");
			byte[] b = new byte[1024];
			int read = inputStream.read(b);
			System.out.println("客户端获取的响应");
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
