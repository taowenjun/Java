package cn.bit.tao.maputil;

import java.util.Map;
/**
 * @author Tao wenjun
 * ����ͼ��ؽӿ�
 */
public interface ISaveAndLoad {
	//����Map
	public Map loadMap(String path);
	
	//����Map
	public void saveMap(String path,Map map);
}
