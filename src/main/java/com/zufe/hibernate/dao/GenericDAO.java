package com.zufe.hibernate.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 泛型DAO接口的实现类
 * 
 * @author 蒋永亮
 * @version 1.00 2011-8-18
 */
@SuppressWarnings( { "unused", "unchecked" })
public class GenericDAO<T extends Serializable, PK extends Serializable>
		extends HibernateDaoSupport implements IGenericDAO<T, PK> {
	
	//static Logger logger = Logger.getLogger(GenericDAO.class) ;
	
	//注入sessionFactory
	@Resource(name="sessionFactory")     
    public void setSuperSessionFactory(SessionFactory sessionFactory) {     
        super.setSessionFactory(sessionFactory);   
    }  
	
	// 实体类类型(由构造方法自动赋值)
	private Class<T> entityClass;
	private final String entity;

	/**
	 * 构造方法，根据实例类自动获取实体类类型
	 */
	public GenericDAO() {
		this.entityClass = null;
		Class c = this.getClass();
		// System.out.println(c);
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.entityClass = (Class<T>) p[0];
		}
		this.entity = this.entityClass.getSimpleName();
		// System.out.println("entity:"+this.entity+
		// "--entityClass:"+this.entityClass);
	}

	/**
	 * 存储实体到数据库
	 */
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	/**
	 * 增加或更新实体
	 */
	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	/**
	 * 增加或更新集合中的全部实体
	 */
	public void saveOrUpdateAll(Collection<T> entities) {
		this.getHibernateTemplate().saveOrUpdateAll(entities);
	}

	/**
	 * 根据主键获取实体。如果没有相应的实体，返回 null。
	 */
	public T get(PK id) {
		return (T) this.getHibernateTemplate().get(this.entityClass, id);
	}

	/**
	 * 删除指定的实体
	 */
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	/**
	 * 删除集合中的全部实体
	 */
	public void deleteAll(Collection<T> entities) {
		this.getHibernateTemplate().deleteAll(entities);
	}

	/*
	 * 根据属性删除(non-Javadoc)
	 * @see com.zufe.dao.generic.GenericDAO#deleteByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public void deleteByProperty(String key, Object value) {
		this.getHibernateTemplate().deleteAll(this.findByProperty(key, value));
	}

	/**
	 * 更新实体
	 */
	public void update(T entity) {
		this.getHibernateTemplate().clear();
		this.getHibernateTemplate().update(entity);
	}

	/**
	 * 更新实体并加锁
	 */
	public void updateWithLock(T entity, LockMode lock) {
		this.getHibernateTemplate().update(entity, lock);
		this.flush(); // 立即刷新，否则锁不会生效。
	}

	/**
	 * 加锁指定的实体
	 * 
	 * @param entity
	 * @param lock TODO
	 */
	public void lock(T entity, LockMode lock) {
		this.getHibernateTemplate().lock(entity, lock);
	}

	/**
	 * 强制初始化指定的实体
	 * 
	 * @param proxy
	 */
	public void initialize(Object proxy) {
		this.getHibernateTemplate().initialize(proxy);
	}

	/**
	 * 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
	 */
	public void flush() {
		this.getHibernateTemplate().flush();
	}

	/**
	 * 使用带参数的HSQL语句检索数据
	 */
	public List find(String queryString, Object[] values) {
		return this.getHibernateTemplate().find(queryString, values);
	}

	/**
	 * 使用HQL语句检索数据
	 */
	public List find(String queryString) {
		return this.getHibernateTemplate().find(queryString);
	}

	/**
	 * 获取全部实体。
	 */
	public List<T> findAll() {
		return this.getHibernateTemplate().loadAll(this.entityClass);
	}

	/**
	 * 获取全部实体、分页、排序
	 */
	public List<T> findAll(final int start, final int limit,
			final String orderby, final String desc) {
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from " + GenericDAO.this.entity
								+ " order by " + orderby + " " + desc;
						Query query = session.createQuery(hql);
						query.setCacheable(true);
						List result = query.setFirstResult(start).setMaxResults(limit).list();
						return result;
					}
				});
		return list;
	}

	/**
	 * 获取全部实体并分页返回
	 */
	public List<T> findAll(final int start, final int limit) {
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from " + GenericDAO.this.entity;
						Query query = session.createQuery(hql);
						query.setCacheable(true);
						List result = query.setFirstResult(start).setMaxResults(limit)
								.list();
						return result;
					}
				});
		return list;
	}

	/**
	 * 根据封装的Map分页查询、指定字段排序
	 */
	public List<T> findByMap(final Map map, final int start, final int limit,
			final String orderby, final String desc) {
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from " + GenericDAO.this.entity
								+ " where " + MapToString(map) + " order by "
								+ orderby + " " + desc;
						Query query = session.createQuery(hql);
						query.setCacheable(true);
						List result = query.setFirstResult(
								start).setMaxResults(limit).list();
						return result;
					}
				});
		return list;
	}

	/**
	 * 根据封装的Map分页查询
	 */
	public List<T> findByMap(final Map map, final int start, final int limit) {
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from " + GenericDAO.this.entity
								+ " where " + MapToString(map);
						Query query = session.createQuery(hql);
						query.setCacheable(true);
						List result = query.setFirstResult(
								start).setMaxResults(limit).list();
						return result;
					}
				});
		return list;
	}

	/**
	 * 根据封装的Map查询
	 */
	public List<T> findByMap(final Map map) {
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from " + GenericDAO.this.entity
								+ " where " + MapToString(map);
						Query query = session.createQuery(hql);
						query.setCacheable(true);
						List result = query.list();
						return result;
					}
				});
		return list;
	}

	/**
	 * 根据key-value精确查找、分页
	 */
	public List<T> findByProperty(final String key, final Object value,
			final int start, final int limit) {
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Map m = new HashMap();
						m.put(key, value);
						String hql = "from " + GenericDAO.this.entity
								+ " where " + MapToString(m);
						Query query = session.createQuery(hql);
						query.setCacheable(true);
						List result = query.setFirstResult(
								start).setMaxResults(limit).list();
						return result;
					}
				});
		return list;
	}

	/**
	 * 根据key-value查找
	 */
	public List<T> findByProperty(final String key, final Object value) {
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Map m = new HashMap();
						m.put(key, value);
						String hql = "from " + GenericDAO.this.entity
								+ " where " + MapToString(m);
						Query query = session.createQuery(hql);
						query.setCacheable(true);
						List result = query.list();
						return result;
					}
				});
		return list;
	}

	/**
	 * 根据key-value模糊查找、分页
	 */
	public List<T> findLikeProperty(final String key, final Object value,
			final int start, final int limit) {
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Map m = new HashMap();
						m.put(key + " like", value);
						String hql = "from " + GenericDAO.this.entity
								+ " where " + MapToString(m);
						Query query = session.createQuery(hql);
						query.setCacheable(true);
						List result = query.setFirstResult(
								start).setMaxResults(limit).list();
						return result;
					}
				});
		return list;
	}

	/**
	 * 根据key-value模糊查找
	 */
	public List<T> findLikeProperty(final String key, final Object value) {
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Map m = new HashMap();
						m.put(key + " like", value);
						String hql = "from " + GenericDAO.this.entity
								+ " where " + MapToString(m);
						Query query = session.createQuery(hql);
						query.setCacheable(true);
						List result = query.list();
						return result;
					}
				});
		return list;
	}

	/**
	 * 获取全部实体的记录数
	 */
	public int getTotalNumber() {
		final String sql = "select count(*) from " + this.entity;
		return ((Number) this.getHibernateTemplate().find(sql).get(0))
				.intValue();
	}

	/**
	 * 根据Map获得总记录数
	 */
	public int getTotalNumber(Map map) {
		final String sql = "select count(*) from " + this.entity + " where "
				+ MapToString(map);
		return ((Number) this.getHibernateTemplate().find(sql).get(0))
				.intValue();
	}

	/**
	 * 将查询Map转换为条件查询where后的字符串
	 * 
	 * @param map 构造的查询map
	 * @return String
	 */
	public static String MapToString(Map map) {
		String str = new String();

		str = "";
		Iterator keyIt = map.keySet().iterator();
		while (keyIt.hasNext()) {
			String key = (String) keyIt.next();
			String value = map.get(key).toString();
			String type = map.get(key).getClass().toString();
			if (type.equals("class java.lang.String")) {
				String name = new String();
				if (key.indexOf(" ") > 0) {
					name = key.substring(0, key.indexOf(" "));
				} else {
					name = key;
				}
				if (key.indexOf("like") > 0) {
					str = str + " " + name + " like '%" + value + "%' ";
				} else {
					str = str + " " + name + " = '" + value + "' ";
				}
			} else if (type.equals("class java.sql.Timestamp")
					|| type.equals("class java.util.Date")) {

				String name = new String();
				if (key.indexOf(" ") > 0) {
					name = key.substring(0, key.indexOf(" "));
				} else {
					name = key;
				}
				if (key.indexOf("begin") > 0) {
					str = str + " " + name + " >= '" + value + "' ";
				} else if (key.indexOf("end") > 0) {
					str = str + " " + name + " <= '" + value + "' ";
				} else {
					str = str + " " + name + " = '" + value + "' ";
				}

			} else if (type.equals("class java.lang.Integer")
					|| type.equals("class java.lang.Double")) {
				String name = new String();
				if (key.indexOf(" ") > 0) {
					name = key.substring(0, key.indexOf(" "));
				} else {
					name = key;
				}
				if (key.indexOf("begin") > 0) {
					str = str + " " + name + " > " + value + " ";
				} else if (key.indexOf("end") > 0) {
					str = str + " " + name + " < " + value + " ";
				} else {
					str = str + " " + name + " = " + value + " ";
				}

			}
			str = str + " and";
		}
		if (str.endsWith(" and")) {
			str = str.substring(0, str.lastIndexOf(" and"));
		} else {
			str = "1=1";
		}
		return str;
	}

}
