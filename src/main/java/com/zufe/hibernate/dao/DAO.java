package com.zufe.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author matrix
 * 2014年2月28日
 */
@Repository
public class DAO{

	@Autowired 
	public SessionFactory sessionFactory;

	/**
	 * 使用HQL语句检索数据
	 * 
	 * @param hql hql查询语句
	 * @return List
	 */
	public List find(String hql) {
		return this.sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	/**
	 * 执行hql语句
	 * @param hql
	 * @return
	 */
	public boolean executeHql(String hql){
		try{
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			query.executeUpdate();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * 存储实体到数据库
	 * @param entity
	 */
	public void save(Object entity) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}
	
	/**
	 * 分页查询
	 * @param hql
	 * @param page
	 * @param limit
	 * @return
	 */
	public List find(String hql,int page,int limit){
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult((page-1)*limit); 
		query.setMaxResults(limit); 
		return query.list();
	}
	
	public int count(String hql){
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		return ((Number)query.uniqueResult()).intValue();
	}
}
