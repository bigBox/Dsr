package com.dj.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSONObject;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Holiday {

	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "/" + param;
			URL realUrl = new URL(urlNameString);
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
 
	static Map totalMap = new TreeMap();
	
	public static void main(String[] args) {
		
		int startYear = 2021;//开始的年份
		int year = 2;		 //统计的年份
		
		for(int i = 0; i <= (year - 1); i++){
			for(int j = 1; j <= 12; j++) {
				loop(startYear + i + "", j + "");
			}
		}
		
		Iterator it = totalMap.keySet().iterator();
		while(it.hasNext()) {
			System.out.println(totalMap.get(it.next()));
		}
		
	}
	
	public static void loop(String year, String month) {
		String s = Holiday.sendGet("http://opendata.baidu.com/api.php?query="+year+"%E5%B9%B4"+month+"%E6%9C%88&resource_id=6018&format=json", "");
		
		Map<String, Object> map = (Map<String, Object>) JSONObject.parse(s);
		
		List list = (List) map.get("data");
		if(list == null || list.size() == 0) {
			return;
		}
		
		Map<String, Object> innerMap = (Map<String, Object>) ( list.get(0));
		if(innerMap.get("holiday") == null) {
			return;
		}
		
		List holidayList = new ArrayList();
		Object obj = innerMap.get("holiday");
		if(obj instanceof List) {
			holidayList = (List) obj;
		}else {
			holidayList.add((Map)obj);
		}
		 
		for(int i = 0; i < holidayList.size(); i++) {
			List innerHolidayList = (List) ((Map)holidayList.get(i)).get("list");
			for(int j = 0; j < innerHolidayList.size(); j++) {
				Map el = (Map) innerHolidayList.get(j);
				totalMap.put(el.get("date"), el.get("date") + "\t" + el.get("status"));
			}
		}
	}
}
