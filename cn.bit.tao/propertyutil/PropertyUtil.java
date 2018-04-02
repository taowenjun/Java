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
 *��ȡ�����ļ�������
 */

public class PropertyUtil {
	private static Logger LOG = Logger.getLogger("util");
	private static Properties props;
	
	static{
		loadProps();
	}
	
	/*
	 * ���������ļ���Property��
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
	 * ��ȡkey��Ӧ������ֵ
	 */
	public static String getProperty(String key){
		if(null==props){
			loadProps();
		}
		return props.getProperty(key);
	}
	
	/*
	 * ��ȡkey��Ӧ������ֵ�����û��ȡ���ͷ���Ĭ��ֵ
	 */
	public static String getProperty(String key,String defaultValue){
		if(null==props){
			loadProps();
		}
		return props.getProperty(key, defaultValue);
	}
}
