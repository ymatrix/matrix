package com.zufe.hibernate.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;

/**
 * 泛型DAO接口,描述了其中方法的作用
 * 
 * @author 蒋永亮
 * @version 1.00 2011-8-31
 */
public interface IGenericDAO<T extends Serializable, PK extends Serializable> {

	
	
	/**
	 * 存储实体到数据库
	 * 
	 * @param entity 实体变量
	 */
	public void save(T entity);

	/**
	 * 增加或更新实体
	 * 
	 * @param entity 实体变量
	 */
	public void saveOrUpdate(T entity);

	/**
	 * 增加或更新集合中的全部实体
	 * 
	 * @param entities 实体的集合
	 */
	public void saveOrUpdateAll(Collection<T> entities);

	/**
	 * 根据主键获取实体。如果没有相应的实体，返回 Null。
	 * 
	 * @param id
	 * @return 实体或Null
	 */
	public T get(PK id);

	/**
	 * 获取全部实体。
	 * 
	 * @return List
	 */
	public List<T> findAll();

	/**
	 * 获取全部实体并分页返回
	 * 
	 * @param start 起始位置
	 * @param limit 显示数目
	 * @return List
	 */
	public List<T> findAll(int start, int limit);

	/**
	 * 获取全部实体、分页、排序
	 * 
	 * @param start 起始位置
	 * @param limit 显示数目
	 * @param orderby 排序字段
	 * @param desc 排序方式
	 * @return List
	 */
	public List<T> findAll(int start, int limit, String orderby, String desc);

	/**
	 * 获取全部实体的记录数
	 * 
	 * @return int
	 */
	public int getTotalNumber();

	/**
	 * 根据Map获得总记录数
	 * 
	 * @param map 构造的查询map
	 * @return int
	 */
	public int getTotalNumber(Map map);

	/**
	 * 使用HQL语句检索数据
	 * 
	 * @param queryString hql查询语句
	 * @return List
	 */
	public List find(String queryString);

	/**
	 * 使用带参数的HQL语句检索数据
	 * 
	 * @param queryString hql查询语句
	 * @param values 查询参数
	 * @return TODO
	 */
	public List find(String queryString, Object[] values);

	/**
	 * 根据key-value精确查找
	 * 
	 * @param start 起始位置
	 * @param limit 显示数目
	 * @return List
	 */
	public List<T> findByProperty(String key, Object value);

	/**
	 * 根据key-value精确查找、分页
	 * 
	 * @param start 起始位置
	 * @param limit 显示数目
	 * @param orderby 排序字段
	 * @param desc 排序方式
	 * @return List
	 */
	public List<T> findByProperty(String key, Object value, int start, int limit);

	/**
	 * 根据key-value模糊查找
	 * 
	 * @param key 属性名称
	 * @param value 属性值
	 * @return List
	 */
	public List<T> findLikeProperty(String key, Object value);

	/**
	 * 根据key-value模糊查找、分页
	 * 
	 * @param key 属性名称
	 * @param value 属性值
	 * @param start 起始位置
	 * @param limit 显示数目
	 * @return List
	 */
	public List<T> findLikeProperty(String key, Object value, int start,
			int limit);

	/**
	 * 根据封装的Map查询
	 * 
	 * @param map 构造的查询map
	 * @return List
	 */
	public List<T> findByMap(Map map);

	/**
	 * 根据封装的Map分页查询
	 * 
	 * @param map 构造的查询map
	 * @param start 起始位置
	 * @param limit 显示数目
	 * @return List
	 */
	public List<T> findByMap(Map map, int start, int limit);

	/**
	 * 根据封装的Map分页查询、指定字段排序
	 * 
	 * @param map 构造的查询map
	 * @param start 起始位置
	 * @param limit 显示数目
	 * @param orderby 排序字段
	 * @param desc 排序方式
	 * @return List
	 */
	public List<T> findByMap(Map map, int start, int limit, String orderby,
			String desc);

	/**
	 * 更新实体
	 * 
	 * @param entity 待更新的实体
	 */
	public void update(T entity);

	/**
	 * 更新实体并加锁
	 * 
	 * @param entity 待更新的实体
	 * @param lock 是否加锁
	 */
	public void updateWithLock(T entity, LockMode lock);

	/**
	 * 删除指定的实体
	 * 
	 * @param entity 待删除的实体变量
	 */
	public void delete(T entity);

	/**
	 * 删除集合中的全部实体
	 * 
	 * @param entities 待删除的变量集合
	 */
	public void deleteAll(Collection<T> entities);

	/**
	 * 根据属性删除
	 * 
	 * @param key 属性名称
	 * @param value 属性值
	 */
	public void deleteByProperty(String key, Object value);

}
