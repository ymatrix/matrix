package com.zufe.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 模型类
 * @author matrix
 * 2014年2月27日
 */
@Entity
@Table(name = "model")
public class Model implements java.io.Serializable{

	private String id;
	
	/**
	 * 模型名称
	 */
	private String name;
	
	/**
	 * 模型描述
	 */
	private String description;
	
	/**
	 * 所属站点
	 */
	private String siteid;
	
	/**
	 * 首页模板
	 */
	private String categoryTemplate;
	
	/**
	 * 列表页模板
	 */
	private String listTemplate;
	
	/**
	 * 展示页模板
	 */
	private String showTemplate;

	/**
	 * 状态
	 */
	private int status;
	
	
	public Model() {
		super();
	}

	public Model(String id, String name, String description, String siteid,
			String categoryTemplate, String listTemplate, String showTemplate,int status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.siteid = siteid;
		this.categoryTemplate = categoryTemplate;
		this.listTemplate = listTemplate;
		this.showTemplate = showTemplate;
		this.status = status;
	}

	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "siteid")
	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	@Column(name = "category_template")
	public String getCategoryTemplate() {
		return categoryTemplate;
	}

	public void setCategoryTemplate(String categoryTemplate) {
		this.categoryTemplate = categoryTemplate;
	}

	@Column(name = "list_template")
	public String getListTemplate() {
		return listTemplate;
	}

	public void setListTemplate(String listTemplate) {
		this.listTemplate = listTemplate;
	}

	@Column(name = "show_template")
	public String getShowTemplate() {
		return showTemplate;
	}

	public void setShowTemplate(String showTemplate) {
		this.showTemplate = showTemplate;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
