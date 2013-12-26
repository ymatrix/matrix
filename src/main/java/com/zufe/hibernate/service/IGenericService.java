package com.zufe.hibernate.service;

import java.io.Serializable;

/**       
 * 泛型Service接口定义
 *
 * @author 蒋永亮         
 * @version 1.00  2011-11-23
 * 
 */
public interface IGenericService<T extends Serializable,PK extends Serializable> {

	/**
     * 存储实体到数据库
     * @param entity
     */
    public boolean save(T entity);
	
    /**
     * 更新实体
     * @param entity
     */
    public boolean update(T entity);
    
    /**
	 * 根据Id查找持久化类,否则返回null
	 * @param id
	 * @return
	 */
	public String findById(int id);
	
	/**
	 * 分页查找,如果存在合法数据,返回Json格式的值,否则返回null
	 * @param start
	 * @param limit
	 * @return
	 */
	public String findAll(int start, int limit);
	
	/**
	 * 根据ID删除,参数格式  例:'1,2,3'
	 * @param ids
	 * @return
	 */
	public boolean deleteByIdS(String ids);
}
