package com.zufe.activiti.ext;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomGroupEntityManagerFactory implements SessionFactory{

	@Autowired 
	private CustomGroupManager customGroupManager;
	
	public Class<?> getSessionType() {
		// TODO Auto-generated method stub
		return CustomGroupManager.class;
	}

	public Session openSession() {
		// TODO Auto-generated method stub
		return customGroupManager;
	}

}
