package cn.bit.tao.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO Server
 * @author Tao wenjun
 * @date 2018年5月25日
 */
public class BioServerTest {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8889);
			while(true){
                Socket socket = serverSocket.accept();				
				System.out.println("接收请求");
				new Thread(new BioServerHandle(socket)).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
