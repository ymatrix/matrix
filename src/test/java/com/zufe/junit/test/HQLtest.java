package com.zufe.junit.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zufe.pojo.Role;

/**
 * @author jyl
 * @version 创建时间：2013-4-12 上午9:25:53
 * 类说明
 */
public class HQLtest {
	
	private static ClassPathXmlApplicationContext ctx;

	
	public void before() {
		String[] locations = { "applicationContext.xml"};
		ctx = new ClassPathXmlApplicationContext(locations);
	}


	public void test(){
		
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sf.openSession();
        
        Transaction transaction = session.beginTransaction();
        String hql = "from Express where sendcode='568379143362'";
        Query query = session.createQuery(hql);
//        Criteria criteria = session.createCriteria(Role.class);
//        criteria.add(Restrictions.eq("id", 2));
        List list = query.list();
        transaction.commit();
	}
}
