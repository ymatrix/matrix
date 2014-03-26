package com.zufe.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zufe.hibernate.dao.Dao;
import com.zufe.utils.DateJsonValueProcessor;

/**       
 * 泛型Service接口实现
 *
 * @author 蒋永亮         
 * @version 1.00  2011-11-23
 * 
 */
@Service
public class GenericService{

	@Resource(name="DAO")
	protected Dao dao;
  
	/**
	 * 属性名称
	 */
	private String entity;

	public void setEntity(String entity){
		this.entity = entity;
	}
	
    /**
     * 存储实体到数据库
     * @param entity
     */
	public boolean save(Object entity) {
		try{
			this.dao.save(entity);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 分页查询
	 * @param hql
	 * @param page
	 * @param limit
	 * @return
	 */
	public String getList(String hql ,int page,int limit){
		List list = dao.find(hql, page, limit);
		JsonValueProcessor jsonProcessor = new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss");
		JsonConfig jsonConfig = new JsonConfig(); // 注册值处理器
		jsonConfig.registerJsonValueProcessor(Timestamp.class, jsonProcessor);
		JSONArray array = JSONArray.fromObject(list,jsonConfig);
		return array.toString();
	}
	
	public int getCount(String hql) {
		return this.dao.count(hql);
	}

	/**
	 * 根据Map获得总记录数
	 */
	public int getCount(Map map) {
		final String sql = "select count(*) from " + this.entity + " where "
				+ MapToString(map);
		return this.dao.count(sql);
	}
	
	/**
	 * 根据Str获得总记录数
	 */
	public int getTotalNumber(String str) {
		final String sql = "select count(*) from " + this.entity + " where "
				+ str;
		return ((Number) this.dao.find(sql).get(0))
				.intValue();
	}

	/**
	 * 将查询Map转换为条件查询where后的字符串
	 * 
	 * @param map 构造的查询map
	 * @return String
	 */
	public static String MapToString(Map map) {
		String str = new String();

		str = "";
		Iterator keyIt = map.keySet().iterator();
		while (keyIt.hasNext()) {
			String key = (String) keyIt.next();
			String value = map.get(key).toString();
			String type = map.get(key).getClass().toString();
			if (type.equals("class java.lang.String")) {
				String name = new String();
				if (key.indexOf(" ") > 0) {
					name = key.substring(0, key.indexOf(" "));
				} else {
					name = key;
				}
				if (key.indexOf("like") > 0) {
					str = str + " " + name + " like '%" + value + "%' ";
				} else {
					str = str + " " + name + " = '" + value + "' ";
				}
			} else if (type.equals("class java.sql.Timestamp")
					|| type.equals("class java.util.Date")) {

				String name = new String();
				if (key.indexOf(" ") > 0) {
					name = key.substring(0, key.indexOf(" "));
				} else {
					name = key;
				}
				if (key.indexOf("begin") > 0) {
					str = str + " " + name + " >= '" + value + "' ";
				} else if (key.indexOf("end") > 0) {
					str = str + " " + name + " <= '" + value + "' ";
				} else {
					str = str + " " + name + " = '" + value + "' ";
				}

			} else if (type.equals("class java.lang.Integer")
					|| type.equals("class java.lang.Double")) {
				String name = new String();
				if (key.indexOf(" ") > 0) {
					name = key.substring(0, key.indexOf(" "));
				} else {
					name = key;
				}
				if (key.indexOf("begin") > 0) {
					str = str + " " + name + " > " + value + " ";
				} else if (key.indexOf("end") > 0) {
					str = str + " " + name + " < " + value + " ";
				} else {
					str = str + " " + name + " = " + value + " ";
				}

			}
			str = str + " and";
		}
		if (str.endsWith(" and")) {
			str = str.substring(0, str.lastIndexOf(" and"));
		} else {
			str = "1=1";
		}
		return str;
	}
	
	
}
