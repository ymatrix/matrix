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
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rolepermission")
public class RolePermission implements java.io.Serializable {

	private String id;
	private String roleid;
	private String permissionid;
 
	public RolePermission() {
		super();
	}

	public RolePermission(String id, String roleid, String permissionid) {
		super();
		this.id = id;
		this.roleid = roleid;
		this.permissionid = permissionid;
	}

	// Property accessors
	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "roleid")
	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	@Column(name = "permissionid")
	public String getPermissionid() {
		return permissionid;
	}

	public void setPermissionid(String permissionid) {
		this.permissionid = permissionid;
	}
	
}