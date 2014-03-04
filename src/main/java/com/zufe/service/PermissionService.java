package com.zufe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zufe.hibernate.dao.DAO;
import com.zufe.pojo.Permission;

/**
 * 
 * @author matrix
 * 2014年2月28日
 */
@Service
public class PermissionService {

	@Autowired
	private DAO dao;
	
	public String getPermissionMenu(){
		List<Permission> list = this.dao.find("from Permission order by level asc,sort desc");
		return "["+getJson(list,"")+"]";
	}
	
	public String getJson(List<Permission> permissions,String parentid){
		String json = "";
		for(int i=0;i<permissions.size();i++){
			Permission permission = permissions.get(i);
			if(permission.getParentid().equals(parentid)){
				if(json.length()>0){json+=",";};
				json += "{\"id\":\""+permission.getId()+"\",\"text\":\""+permission.getName()+"\",\"isleaf\":"+permission.getLevel()+",\"url\":\""+permission.getUrl()+"\"";
				if(permission.isIsleaf()){
					json+="}";
				}else{
					json+=",\"children\":["+ getJson(permissions,permission.getId())+"]}";
				}
			}
		}
		if(json.length()==0){
			json = "{}";
		}
		return json;
	}
}
