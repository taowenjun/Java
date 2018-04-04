package cn.bit.tao.maputil;

import java.util.Map;

/**
 * @author Tao wenjun
 * Map和String相互转换
 */
public interface IMapTransString {
	//Map转成String
	String transMapToString(Map map);
	
	//String转成Map
	Map transStringToMap(String str);
}
