package cn.bit.tao.maputil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
/**
 * @author Tao wenjun
 * MapUtil :保存和加载Map中的内容
 */
public class MapUtil implements ISaveAndLoad,IMapTransString{
	
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("file1", "hadoop");
		map.put("file2", "kafka");
		map.put("file3", "storm");
		MapUtil util = new MapUtil();
		util.saveMap("D:\\tmp\\map.txt", map);
		Map loadMap = util.loadMap("D:\\tmp\\map.txt");
		System.out.println(loadMap.getOrDefault("file1","****"));
		String str = util.transMapToString(map);
		System.out.println(str);
		System.out.println(util.transStringToMap(str).toString());
	}

	@Override
	public Map loadMap(String path) {
		ObjectInputStream in = null;
		try {
			 in = new ObjectInputStream(new FileInputStream(new File(path)));
		     Object readObject = in.readObject();
		     if(readObject==null){
		    	 return new HashMap();
		     }else{
		    	 return (HashMap)readObject;
		     }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public void saveMap(String path, Map map) {
		if(map==null){
			return;
		}
		ObjectOutputStream output = null;
		try {
			output = new ObjectOutputStream(new FileOutputStream(new File(path)));
		    output.writeObject(map);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(output!=null){
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public String transMapToString(Map map) {
		Map.Entry<String, String> entry = null;
		StringBuffer sb = new StringBuffer();
		for(Iterator iterator = map.entrySet().iterator();iterator.hasNext();){
			entry = (Entry) iterator.next();
			sb.append(entry.getKey().toString()).append("'").
			append(null==entry.getValue()?"":entry.getValue().toString()).append(iterator.hasNext()?"^":"");
		}
		return sb.toString();
	}

	@Override
	public Map transStringToMap(String str) {
		Map map = new HashMap();
		StringTokenizer items=null;
		for(StringTokenizer entrys=new StringTokenizer(str, "^");entrys.hasMoreTokens();){
			items=new StringTokenizer(entrys.nextToken(), "'");
			map.put(items.nextToken(), items.hasMoreTokens()?items.nextToken():"");
		}
		return map;
	}

}
