package com.zufe.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author matrix
 * 2014年2月28日
 */
@Repository
public class DAO{

	@Autowired 
	private SessionFactory sessionFactory;

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
	 * 存储实体到数据库
	 * @param entity
	 */
	public void save(Object entity) {
		this.sessionFactory.getCurrentSession().save(entity);
	}
}
