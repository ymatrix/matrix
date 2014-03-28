package com.zufe.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 用户dao
 * @author matrix
 * 2014年3月26日
 */
@Repository
public class UserDao extends Dao {
 
	@Autowired 
	public SessionFactory sessionFactory;
	
}
