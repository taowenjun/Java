package cn.bit.tao.maputil;

import java.util.Map;

/**
 * @author Tao wenjun
 * Map��String�໥ת��
 */
public interface IMapTransString {
	//Mapת��String
	String transMapToString(Map map);
	
	//Stringת��Map
	Map transStringToMap(String str);
}
