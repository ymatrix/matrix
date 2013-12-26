package com.zufe.hibernate.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.stereotype.Service;
import com.zufe.hibernate.dao.IGenericDAO;

/**       
 * 泛型Service接口实现
 *
 * @author 蒋永亮         
 * @version 1.00  2011-11-23
 * 
 */
@Service
public class GenericService <T extends Serializable,PK extends Serializable> implements IGenericService<T,PK> {

	private IGenericDAO genericDAO;

	public void setGenericDAO(IGenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

    /**
     * 存储实体到数据库
     * @param entity
     */
	public boolean save(T entity) {
		try{
			this.genericDAO.save(entity);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	/**
     * 更新实体
     * @param entity
     */
    public boolean update(T entity) {
    	try{
    		this.genericDAO.saveOrUpdate(entity);
    		return true;
    	}catch (Exception e) {
    		return false;
		}
	}

	/**
	 * 根据Id查找持久化类,不存在则返回null
	 * @param id
	 * @return
	 */
	public String findById(int id) {
		try{
			T dao = (T) this.genericDAO.get(id);
			String json = null;
			if(dao!=""||dao!=null){
//				 JsonValueProcessor jsonProcessor = new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss");
//				 JsonConfig jsonConfig = new JsonConfig(); // 注册值处理器
//				 jsonConfig.registerJsonValueProcessor(Timestamp.class, jsonProcessor);
//
//				json = JSONSerializer.toJSON(dao,jsonConfig).toString();
			}
			return json;
		}catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 分页查找,如果存在合法数据,返回Json格式的值,否则返回null
	 * @param start
	 * @param limit
	 * @return
	 */
	public String findAll(int start, int limit) {
		try{
			List<T> list = this.genericDAO.findAll(start, limit);
			String json=null;
			
//			JsonValueProcessor jsonProcessor = new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss");
//			JsonConfig jsonConfig = new JsonConfig(); // 注册值处理器
//			jsonConfig.registerJsonValueProcessor(Timestamp.class, jsonProcessor);
//
//			if(list.size()>0){
//				json = "{" 
//						+"\"rows\":" + JSONSerializer.toJSON(list,jsonConfig).toString()+","
//						+"\"total\":"+ this.genericDAO.getTotalNumber() 
//						+ "}";
//			}
			return json;
		}catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据ID删除,参数格式  例:'1,2,3'
	 * @param ids
	 * @return
	 */
	public boolean deleteByIdS(String ids) {
		try{
			String[] idArray = ids.split(",");
			for(int i=0;i<idArray.length;i++){
				this.genericDAO.delete(this.genericDAO.get(idArray[i]));
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
}
