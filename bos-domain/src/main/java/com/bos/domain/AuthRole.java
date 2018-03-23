package com.bos.domain;
// Generated 2018-3-23 20:56:56 by Hibernate Tools 3.6.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AuthRole generated by hbm2java
 */
@Entity
@Table(name = "auth_role", catalog = "bos")
public class AuthRole implements java.io.Serializable {

	private String id;
	private String name;
	private String code;
	private String description;

	public AuthRole() {
	}

	public AuthRole(String id) {
		this.id = id;
	}

	public AuthRole(String id, String name, String code, String description) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code")
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
