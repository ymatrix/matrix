package com.zufe.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 用户组dao
 * @author matrix
 * 2014年3月26日
 */
@Repository
public class GroupDao extends Dao {

	@Autowired 
	public SessionFactory sessionFactory;
}
