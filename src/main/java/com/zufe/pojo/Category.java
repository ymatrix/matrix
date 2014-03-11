package com.zufe.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 栏目类
 * @author matrix
 * 2014年2月27日
 */
@Entity
@Table(name = "category")
public class Category implements java.io.Serializable{

	private String id;
	
	/**
	 * 所属站点
	 */
	private String siteid;
	
	/**
	 * 权限名称
	 */
	private String name;
	
	/**
	 * 父节点id
	 */
	private String parentid;
	
	/**
	 * 栏目级别
	 */
	private int level;
	
	/**
	 * 模型id
	 */
	private String modelid;
	
	/**
	 * 栏目图片
	 */
	private String image;
	
	/**
	 * 栏目描述
	 */
	private String description;
	
	/**
	 * 是否子栏目
	 */
	private boolean isleaf;
	
	/**
	 * 栏目排序
	 */
	private int sort;
	
	/**
	 * 栏目类型 0-单页面，1-内容页面
	 */
	private int categoryType;
	
	/**
	 * 是否在首页导航条显示
	 */
	private boolean isshow;

	
	public Category() {
		super();
	}

	public Category(String id, String siteid, String name, String parentid,
			int level, String modelid, String image, String description,
			boolean isleaf, int sort, int categoryType, boolean isshow) {
		super();
		this.id = id;
		this.siteid = siteid;
		this.name = name;
		this.parentid = parentid;
		this.level = level;
		this.modelid = modelid;
		this.image = image;
		this.description = description;
		this.isleaf = isleaf;
		this.sort = sort;
		this.categoryType = categoryType;
		this.isshow = isshow;
	}

	@Id
	@GenericGenerator(name="uuid",strategy="org.hibernate.id.UUIDGenerator")
	@GeneratedValue(generator="uuid")
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "siteid")
	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	@Column(name = "name")
	public String getName() {
		return name;
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

	@Column(name = "level")
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Column(name = "modelid")
	public String getModelid() {
		return modelid;
	}

	public void setModelid(String modelid) {
		this.modelid = modelid;
	}

	@Column(name = "image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Column(name = "category_type")
	public int getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(int categoryType) {
		this.categoryType = categoryType;
	}

	@Column(name = "isshow")
	public boolean isIsshow() {
		return isshow;
	}

	public void setIsshow(boolean isshow) {
		this.isshow = isshow;
	}
	
}
