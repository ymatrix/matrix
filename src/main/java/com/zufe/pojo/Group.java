package com.zufe.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户组
 * @author matrix
 * 2014年3月26日
 */
public class Group implements java.io.Serializable{

	private String id;
	
	/**
	 * 组名称
	 */
	private String name;
	
	/**
	 * 描述
	 */
	private String description;

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Group(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	@Id
	@GenericGenerator(name="uuid",strategy="org.hibernate.id.UUIDGenerator")
	@GeneratedValue(generator="uuid")
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		if("".equals(id)){
			return;
		}
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
