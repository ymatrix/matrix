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
 * 
 * @author matrix
 * 2014年2月27日
 */
@Entity
@Table(name = "user")
public class User implements java.io.Serializable {

	private String id;
	/**
	 * 登陆名
	 */
	private String username;
	
	/**
	 * 登陆密码
	 */
	private String password;
	
	/**
	 * 真实姓名
	 */
	private String realname;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 邮箱
	 */
	private String mail;
	
	/**
	 * 电话
	 */
	private String tel;
	
	/**
	 * 联系地址
	 */
	private String address;
	
	/**
	 * 职位
	 */
	private String position;
	
	/**
	 * 工号
	 */
	private String jobNo;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 最后登陆时间
	 */
	private Date loginDate;

	/**
	 * 最后登陆IP
	 */
	private String loginIp;
	
	/**
	 * 角色ID
	 */
	private String roleid;

	public User() {
		super();
	}

	public User(String id, String username, String password, String realname,
			String sex, String mail, String tel, String address, String position, String jobNo, Date createDate,
			Date loginDate, String loginIp,String roleid) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.mail = mail;
		this.tel = tel;
		this.address = address;
		this.position = position;
		this.jobNo = jobNo;
		this.createDate = createDate;
		this.loginDate = loginDate;
		this.loginIp = loginIp;
		this.roleid = roleid;
	}

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
	
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "realname")
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "sex")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "tel")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "position")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "jobno")
	public String getJobNo() {
		return jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	@Column(name = "createdate")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "logindate")
	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Column(name = "loginip")
	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@Column(name = "roleid")
	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	

}