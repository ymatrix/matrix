package com.zufe.activiti.ext;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomUserEntityManagerFactory implements SessionFactory{

	@Autowired 
	private CustomUserManager customUserManager;

	public Class<?> getSessionType() {
		// TODO Auto-generated method stub
		return CustomUserManager.class;
	}

	public Session openSession() {
		// TODO Auto-generated method stub
		return customUserManager;
	}

}
