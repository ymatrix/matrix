package com.zufe.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author matrix
 * 2014年2月27日
 */
@Entity
@Table(name = "permission")
public class Permission implements java.io.Serializable {

	private String id;
	
	/**
	 * 权限名称
	 */
	private String name;
	
	/**
	 * 父节点id
	 */
	private String parentid;
	
	/**
	 * 是否子节点
	 */
	private boolean isleaf;
	
	/**
	 * 排序
	 */
	private int sort;
	
	/**
	 * 栏目等级
	 */
	private int level;
	
	/**
	 * 页面地址
	 */
	private String url;
	
	/**
	 * 图片地址
	 */
	private String picurl;

	/**
	 * 标识
	 */
	private String flag;
 
	
	public Permission() {
		super();
	}

	public Permission(String id, String name, String parentid, boolean isleaf,
			int sort,int level, String url, String picurl,String flag) {
		super();
		this.id = id;
		this.name = name;
		this.parentid = parentid;
		this.isleaf = isleaf;
		this.sort = sort;
		this.url = url;
		this.picurl = picurl;
		this.flag = flag;
		this.level = level;
	}

	@Id
	@GenericGenerator(name="uuid",strategy="org.hibernate.id.UUIDGenerator")
	@GeneratedValue(generator="uuid")
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "parentid")
	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	@Column(name = "isleaf")
	public boolean isIsleaf() {
		return isleaf;
	}

	public void setIsleaf(boolean isleaf) {
		this.isleaf = isleaf;
	}

	@Column(name = "sort")
	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Column(name = "level")
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "picurl")
	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	@Column(name = "flag")
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	

}