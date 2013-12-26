package com.zufe.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "teacher")
public class Teacher {

	private String age;
	private int id;
	private String name;
	private Set<Student> students;
	
	public Teacher() {
		super();
	}
	public String getAge() {
		return age;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@OneToMany(mappedBy="teacher")
	public Set<Student> getStudents() {
		return students;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
