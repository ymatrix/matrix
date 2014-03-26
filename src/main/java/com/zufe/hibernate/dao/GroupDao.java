package com.zufe.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupDao extends Dao {

	@Autowired 
	public SessionFactory sessionFactory;
	
	
}
