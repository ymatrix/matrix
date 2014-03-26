package com.zufe.activiti.ext;

import java.util.List;
import java.util.Map;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zufe.hibernate.dao.UserDao;

@Repository
public class CustomUserManager extends UserEntityManager{

	private static final Log logger = LogFactory.getLog(CustomUserManager.class);

	@Autowired 
	private UserDao userDao;

	@Override
	public User createNewUser(String userId) {
		// TODO Auto-generated method stub
		return super.createNewUser(userId);
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		super.insertUser(user);
	}

	@Override
	public void updateUser(User updatedUser) {
		// TODO Auto-generated method stub
		super.updateUser(updatedUser);
	}

	@Override
	public User findUserById(String userId) {
		// TODO Auto-generated method stub
		return super.findUserById(userId);
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		super.deleteUser(userId);
	}

	@Override
	public List<User> findUserByQueryCriteria(UserQueryImpl query, Page page) {
		// TODO Auto-generated method stub
		return super.findUserByQueryCriteria(query, page);
	}

	@Override
	public long findUserCountByQueryCriteria(UserQueryImpl query) {
		// TODO Auto-generated method stub
		return super.findUserCountByQueryCriteria(query);
	}

	@Override
	public List<Group> findGroupsByUser(String userId) {
		// TODO Auto-generated method stub
		return super.findGroupsByUser(userId);
	}

	@Override
	public UserQuery createNewUserQuery() {
		// TODO Auto-generated method stub
		return super.createNewUserQuery();
	}

	@Override
	public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId,
			String key) {
		// TODO Auto-generated method stub
		return super.findUserInfoByUserIdAndKey(userId, key);
	}

	@Override
	public List<String> findUserInfoKeysByUserIdAndType(String userId,
			String type) {
		// TODO Auto-generated method stub
		return super.findUserInfoKeysByUserIdAndType(userId, type);
	}

	@Override
	public Boolean checkPassword(String userId, String password) {
		// TODO Auto-generated method stub
		return super.checkPassword(userId, password);
	}

	@Override
	public List<User> findPotentialStarterUsers(String proceDefId) {
		// TODO Auto-generated method stub
		return super.findPotentialStarterUsers(proceDefId);
	}

	@Override
	public List<User> findUsersByNativeQuery(Map<String, Object> parameterMap,
			int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return super.findUsersByNativeQuery(parameterMap, firstResult, maxResults);
	}

	@Override
	public long findUserCountByNativeQuery(Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return super.findUserCountByNativeQuery(parameterMap);
	}

	@Override
	public boolean isNewUser(User user) {
		// TODO Auto-generated method stub
		return super.isNewUser(user);
	}

	@Override
	public Picture getUserPicture(String userId) {
		// TODO Auto-generated method stub
		return super.getUserPicture(userId);
	}

	@Override
	public void setUserPicture(String userId, Picture picture) {
		// TODO Auto-generated method stub
		super.setUserPicture(userId, picture);
	}
	
 
	
}
