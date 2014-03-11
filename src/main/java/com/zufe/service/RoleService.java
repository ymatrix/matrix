package com.zufe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zufe.pojo.Role;
import com.zufe.pojo.User;

/**
 * 
 * @author matrix
 * 2014年3月5日
 */
@Service
public class RoleService extends GenericService {

	
	public RoleService() {
		super();
		super.setEntity("Role");
	}

	public String getList(String userid,int page,int limit){
		String hql = "select new Map(id as id,name as name,status as status,userid as userid) from Role where userid='"+userid+"'";
		String hql_count = "select count(*) from Role where userid='"+userid+"'";
		
		String json = "{\"rows\":" + super.getList(hql, page, limit) + ",\"total\":"
				+ super.getCount(hql_count) + "}";
		return json;
	}

	
	public boolean deleteById(String id){
		String hql = "delete from Role where id='"+id+"'";
		return this.dao.executeHql(hql);
	}
	
	public void changeStatus(String id){
		Role role = this.getById(id);
		if(role!=null){
			role.setStatus(1-role.getStatus());
			this.dao.save(role);
		}
	}
	
	public Role getById(String id){
		String hql = " from Role where id='"+id+"'";
		List list = this.dao.find(hql);
		if(list!=null&&list.size()>0){
			return (Role) list.get(0);
		}else{
			return null;
		}
	}
}
