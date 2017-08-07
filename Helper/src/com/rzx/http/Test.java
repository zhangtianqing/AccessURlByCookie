package com.rzx.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.rzx.proper.PropertiesUtil;

public class Test implements Runnable {

	static int i = 1;
	static HttpObject httpObject;
	private static String cookieConfigName = "cookie.properties";

	/**
	 * 线程方法 这里并没有要求返回值
	 * 所以没有使用callback
	 * 
	 */
	public void run() {
		try {
			while (true) {
				HttpHelper.connect(httpObject.url).charset("utf-8").cookies(httpObject.cookies).data(httpObject.data)
						.post();

				System.out.println("http request finish,run " + i++);
				Thread.sleep(6000);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		httpObject = new HttpObject();
		httpObject.cookies = getCookies();
		// entId=6db395e4-ce84-420b-818d-e2d5d96a32b5&flush=b02eb513-b7b0-4abf-83a9-9de32a3388f0
		httpObject.data = getData();
		httpObject.url = "http://www.hrm.cn/company/company_Ma_MaCenter";
		Test test = new Test();
		Thread thread = new Thread(test);
		thread.start();

	}

	/**
	 * 完成 从配置文件中获取要发送的数据
	 * 
	 * @return
	 */
	public static Map<String, String> getData() {
		Map<String, String> map = new HashMap<String, String>();
		PropertiesUtil proName = new PropertiesUtil("config.properties");
		map.put(proName.getProperties().getProperty("data").trim().split("&")[0].split("=")[0],
				proName.getProperties().getProperty("data").trim().split("&")[0].split("=")[1]);
		map.put(proName.getProperties().getProperty("data").trim().split("&")[1].split("=")[0],
				proName.getProperties().getProperty("data").trim().split("&")[1].split("=")[1]);
		return map;
	}

	/**
	 * 完成 根据cookie字符串生成map
	 * 
	 * @return cookie 组
	 */
	public static Map<String, String> getCookies() {
		PropertiesUtil strs=new PropertiesUtil(cookieConfigName);
		Map<String, String> cookie=strs.getIteratorPropre();
		return cookie;
	}

}
