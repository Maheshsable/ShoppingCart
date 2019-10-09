package com.app.bv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="regoister2")
public class Register {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",length=10)
	private Integer id;
	@Column(name="userName",length=10)
	private String userName;
	@Column(name="password",length=10)
	private String password;
	@Column(name="email",length=20)
	private String email;
	@Column(name="address",length=10)
	private String address;
	@Column(name="phone_No",length=10)
	private String phone_No;
	public String getPhone_No() {
		return phone_No;
	}
	public void setPhone_No(String phone_No) {
		this.phone_No = phone_No;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", address=" + address
				+ ", phone_No=" + phone_No + "]";
	}
	
	
	
	

}
