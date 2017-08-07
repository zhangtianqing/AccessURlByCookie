package com.rzx.http;

import java.util.HashMap;
import java.util.Map;

public class HttpObject {

	public String url="";
	public String charset="";
	public Map<String, String> cookies= new HashMap<String, String>();
	public Map<String, String> data= new HashMap<String, String>();
}
