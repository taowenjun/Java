package cn.tao.hadooprpc.client;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import cn.tao.hadooprpc.protocol.ClientNameNodeProtocol;

public class MyHDFSClient {

	public static void main(String[] args) throws IOException {
		ClientNameNodeProtocol namenode = RPC.getProxy(ClientNameNodeProtocol.class, 1L, new InetSocketAddress("localhost",8888), new Configuration());
		String metaData = namenode.getMetaData("/b.txt");
	    System.out.println(metaData);
	    
	}

}
