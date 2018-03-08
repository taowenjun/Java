package cn.tao.hadooprpc.service;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Builder;
import org.apache.hadoop.ipc.RPC.Server;

import cn.tao.hadooprpc.protocol.ClientNameNodeProtocol;
import cn.tao.hadooprpc.protocol.IUserLoginService;

public class PublishServiceUtil {

	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		Builder builder = new RPC.Builder(new Configuration());
	    builder.setBindAddress("localhost")
	    .setPort(8888)
	    .setProtocol(ClientNameNodeProtocol.class)
	    .setInstance(new MyNameNode());
	    
	    Server server = builder.build();
	    
	    server.start();
	    
	    Builder builder2 = new RPC.Builder(new Configuration());
	    builder2.setBindAddress("localhost")
	    .setPort(8889)
	    .setProtocol(IUserLoginService.class)
	    .setInstance(new LoginServiceImpl());
	    
	    Server server2 = builder2.build();
	    
	    server2.start();
	}
}
