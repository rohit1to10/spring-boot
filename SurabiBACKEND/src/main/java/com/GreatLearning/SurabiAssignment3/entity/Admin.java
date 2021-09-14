package com.GreatLearning.SurabiAssignment3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "admin")
public class Admin {
	
//	@Getter
//	@Setter
	@Id
	@Column(name = "adminId")
	private int id;
	@Column(name = "adminName")
	private String name;
	@Column(name = "adminPassword")
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
