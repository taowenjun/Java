package cn.bit.tao.io.bio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * BIO Server处理线程
 * 根据客户端的请求数据返回响应的结果
 * @author Tao wenjun
 * @date 2018年5月25日
 */
public class BioServerHandle implements Runnable {

	private Socket socket;
	
	public BioServerHandle(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		byte[] bytes = new byte[1024];
		try {
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			while(true){
				
				int read = inputStream.read(bytes);
	
				if(read!=-1){
					String body = new String(bytes,0,read);
					System.out.println("the order is :"+body);	
					String currentTime = "query time".equals(body)?new Date(System.currentTimeMillis()).toString():"no query";
					outputStream.write(currentTime.getBytes("utf-8"));				
				}
			
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
