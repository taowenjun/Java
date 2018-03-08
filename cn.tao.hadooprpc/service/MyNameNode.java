package cn.tao.hadooprpc.service;

import cn.tao.hadooprpc.protocol.ClientNameNodeProtocol;

public class MyNameNode implements ClientNameNodeProtocol{
	
	//模拟NameNode的业务方法之一：查询元数据
	@Override
	public String getMetaData(String path){
		return path+": 3 - {BLK_1,BLK_2}";
	}
}
