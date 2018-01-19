package codeura.com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	@Column(unique=true, nullable = false)
	private String cid;
	private String name;
	private String phone;
	private String email;
	private Date date = new Date();
	
	public Customer() {
		super();
	}


	public Customer(String cid, String name, String phone, String email) {
		super();
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}



	public Customer(String cid, String name, String phone, String email, Date date) {
		super();
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCid() {
		return cid;
	}


	public void setCid(String cid) {
		this.cid = cid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
