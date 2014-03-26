package com.zufe.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author matrix
 * 2014年3月10日
 */
@Repository
public class SiteDao extends Dao {

	public List getList(int page,int limit){
		
		String hql = "select new Map(id as id,name as name,dirname as dirname,domain as domain,title as title,keyword as keyword,description as description) from Site";
		
		return this.find(hql, page, limit);
	}
	
	public int getCount(){
		String hql = "select count(*) from Site";
		return this.count(hql);
	}
	
	public boolean deleteById(String id){
		try{
			String hql = "delete from Site where id='"+id+"'";
			Query query = super.sessionFactory.getCurrentSession().createQuery(hql);
			query.executeUpdate();
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
