package com.albertsalud.hibernate.relationships.oneToMany.unidirectional;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone {
	
	@Id
	private long id;
	private String phoneNumber;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
