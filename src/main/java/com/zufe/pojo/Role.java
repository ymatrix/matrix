package com.zufe.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author matrix
 */
@Entity
@Table(name = "role")
public class Role implements java.io.Serializable {

	private String id;
	
	/**
	 * 角色名称
	 */
	private String name;
	
	/**
	 * 创建用户
	 */
	private String userid;
	
	/**
	 * 创建日期
	 */
	private Date createDate;
	
	/**
	 * 状态
	 */
	private int status;

 
	public Role() {
		super();
	}

	public Role(String id, String name, String userid, Date createDate,
			int status) {
		super();
		this.id = id;
		this.name = name;
		this.userid = userid;
		this.createDate = createDate;
		this.status = status;
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

	@Column(name = "userid")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "createdate")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}