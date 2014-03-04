package com.zufe.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 站点类
 * @author matrix
 * 2014年2月27日
 */
@Entity
@Table(name="site")
public class Site implements java.io.Serializable {

	private String id;
	
	/**
	 * 站点名称
	 */
	private String name;
	
	/**
	 * 目录名称
	 */
	private String dirname;
	
	/**
	 * 域名
	 */
	private String domain;
	
	/**
	 * 站点标题
	 */
	private String title;
	
	/**
	 * 关键字
	 */
	private String keyword;
	
	/**
	 * 描述
	 */
	private String description;

	
	public Site() {
		super();
	}

	public Site(String id, String name, String dirname, String domain,
			String title, String keyword, String description) {
		super();
		this.id = id;
		this.name = name;
		this.dirname = dirname;
		this.domain = domain;
		this.title = title;
		this.keyword = keyword;
		this.description = description;
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

	@Column(name = "dirname")
	public String getDirname() {
		return dirname;
	}

	public void setDirname(String dirname) {
		this.dirname = dirname;
	}

	@Column(name = "domain")
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "keyword")
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
