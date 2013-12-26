package com.zufe.dao;

import org.springframework.stereotype.Repository;
import com.zufe.hibernate.dao.GenericDAO;
import com.zufe.pojo.User;

/**
 * @author jyl
 * @version 创建时间：2011-8-16 下午05:10:15
 * 类说明
 */
@Repository
public class UserDAO extends GenericDAO<User, Integer> {

}
