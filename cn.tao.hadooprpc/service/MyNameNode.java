package cn.tao.hadooprpc.service;

import cn.tao.hadooprpc.protocol.ClientNameNodeProtocol;

public class MyNameNode implements ClientNameNodeProtocol{
	
	//ģ��NameNode��ҵ�񷽷�֮һ����ѯԪ����
	@Override
	public String getMetaData(String path){
		return path+": 3 - {BLK_1,BLK_2}";
	}
}
