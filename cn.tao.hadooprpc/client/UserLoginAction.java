package cn.tao.hadooprpc.client;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.ProtocolProxy;
import org.apache.hadoop.ipc.RPC;

import cn.tao.hadooprpc.protocol.IUserLoginService;

public class UserLoginAction {
	public static void main(String[] args) throws IOException {
		IUserLoginService proxy = RPC.getProxy(IUserLoginService.class, 1L, new InetSocketAddress("localhost", 8889), new Configuration());
	    String string = proxy.login("tao", "123");
	    System.out.println(string);
	}
}
