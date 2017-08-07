package com.rzx.proper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesUtil {
	static Properties prop = new Properties();
	/**
	 * 根据路径初始化PropertiesUtil工具 对象类
	 * 获取所有的键值对Map
	 * 获取properties对象
	 * 遍历键/值/键值对输出
	 * @param proName
	 */
	public PropertiesUtil(String proName) {
		
		File file=new File(proName);
		InputStream in;
		try {
			in = new FileInputStream(file);
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  Properties getProperties() {
		return prop;
	}

	
	public Map<String, String> getIteratorPropre(){
		return showKeysAndValues(getProperties());
		
	}
	/** 
     * @param properties 
     */  
    private static void showKeys(Properties properties) {  
        Enumeration<?> enu = properties.propertyNames();  
        while (enu.hasMoreElements()) {  
            Object key = enu.nextElement();  
            System.out.println(key);  
        }  
    }  
  
    /** 
     * @param properties 
     */  
    private static void showValues(Properties properties) {  
        Enumeration<Object> enu = properties.elements();  
        while (enu.hasMoreElements()) {  
            Object value = enu.nextElement();  
            System.out.println(value);  
        }  
    }  
  
    /** 
     * 遍历properties 获取键值对
     * @param properties 
     */  
    public  static  Map<String, String> showKeysAndValues(Properties properties) {  
        Iterator<Entry<Object, Object>> it = properties.entrySet().iterator();
        Map<String, String> map=new HashMap<String,String>();
        while (it.hasNext()) {  
            Entry<Object, Object> entry = it.next();  
            Object key = entry.getKey();  
            Object value = entry.getValue();  
            map.put((String)key,(String) value);
            System.out.println("key   :" + key);  
            System.out.println("value :" + value);  
            System.out.println("---------------");  
        }  
        return map;
    }  

	
//	public static void main(String args[]) {
//		proName=args[0];
//		System.out.println(getParam1());
//		System.out.println(getParam2());
//	}
}
