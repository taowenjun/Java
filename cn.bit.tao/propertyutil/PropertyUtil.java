package cn.bit.tao.propertyutil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *@author  tao wenjun
 *
 *读取配置文件工具类
 */

public class PropertyUtil {
	private static Logger LOG = Logger.getLogger("util");
	private static Properties props;
	
	static{
		loadProps();
	}
	
	/*
	 * 加载配置文件到Property中
	 */
	synchronized private static void loadProps(){
		props = new Properties();
		InputStream in = null;
	    try {
	    	in = PropertyUtil.class.getResourceAsStream(File.pathSeparator+"conf"+File.pathSeparator+"SysConfig.properties");
			props.load(in);
		} catch (IOException e) {
			LOG.log(Level.OFF, e.getMessage());
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				LOG.log(Level.OFF, e.getMessage());
			}
		}
	}
	
	/*
	 * 获取key对应的配置值
	 */
	public static String getProperty(String key){
		if(null==props){
			loadProps();
		}
		return props.getProperty(key);
	}
	
	/*
	 * 获取key对应的配置值，如果没有取到就返回默认值
	 */
	public static String getProperty(String key,String defaultValue){
		if(null==props){
			loadProps();
		}
		return props.getProperty(key, defaultValue);
	}
}
