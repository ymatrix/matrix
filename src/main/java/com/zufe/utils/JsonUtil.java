package com.zufe.utils;

import java.sql.Timestamp;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonUtil {

	public static String arrayToJson(List list){
		JsonValueProcessor jsonProcessor = new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss");
		JsonConfig jsonConfig = new JsonConfig(); // 注册值处理器
		jsonConfig.registerJsonValueProcessor(Timestamp.class, jsonProcessor);
		JSONArray array = JSONArray.fromObject(list,jsonConfig);
		return array.toString();
	}
}
