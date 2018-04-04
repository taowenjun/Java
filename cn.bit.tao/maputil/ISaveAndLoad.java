package cn.bit.tao.maputil;

import java.util.Map;
/**
 * @author Tao wenjun
 * 保存和加载接口
 */
public interface ISaveAndLoad {
	//加载Map
	public Map loadMap(String path);
	
	//保存Map
	public void saveMap(String path,Map map);
}
