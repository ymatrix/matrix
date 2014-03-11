package com.zufe.service;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.zufe.hibernate.dao.SiteDAO;
import javax.annotation.Resource;
/**
 * 
 * @author matrix
 * 2014年3月5日
 */
@Service
public class SiteService extends GenericService {

	@Resource(name="siteDAO")
	public SiteDAO siteDao;

	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @return
	 */
	public String getList(int page,int limit){
		String json = "{\"rows\":" + JSONArray.fromObject(this.siteDao.getList(page, limit)) + ",\"total\":"
				+ this.siteDao.getCount() + "}";
		return json;
	}
	
	public boolean deleteById(String id){
		return this.siteDao.deleteById(id);
	}
}
