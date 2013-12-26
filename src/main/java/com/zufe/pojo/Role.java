package com.zufe.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role")
@Cache(usage =CacheConcurrencyStrategy.READ_WRITE)
public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String permission;
	private String status;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String name, String permission, String status) {
		this.name = name;
		this.permission = permission;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "permission")
	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}