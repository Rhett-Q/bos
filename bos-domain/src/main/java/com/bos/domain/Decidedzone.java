package com.bos.domain;
// Generated 2018-3-22 20:02:41 by Hibernate Tools 3.6.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Decidedzone generated by hbm2java
 */
@Entity
@Table(name = "decidedzone", catalog = "bos")
public class Decidedzone implements java.io.Serializable {

	private String id;
	private String name;
	private Staff staff;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	
}
