package com.zufe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zufe.pojo.User;

/**
 * 
 * @author matrix
 * 2014年3月5日
 */
@Service
public class UserService extends GenericService {

	
	public UserService() {
		super();
		super.setEntity("User");
	}

	public String getList(int page,int limit){
		String hql = "select new Map(id as id,username as username,password as password,realname as realname,email as email,roleid as roleid,loginIp as loginIp) from User";
		String hql_count = "select count(*) from User";
		
		String json = "{\"rows\":" + super.getList(hql, page, limit) + ",\"total\":"
				+ super.getCount(hql_count) + "}";
		return json;
	}
	
	
	public User getByName(String name){
		
		String hql = "from User where username='"+name+"'";
		
		List list = this.dao.find(hql);
		
		if(list!=null&&list.size()>0){
			return (User) list.get(0);
		}else{
			return null;
		}
	}
	
	public boolean deleteById(String id){
		String hql = "delete from User where id='"+id+"'";
		return this.dao.executeHql(hql);
	}
}
