package com.bos.domain;
// Generated 2018-3-23 20:56:56 by Hibernate Tools 3.6.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AuthFunction generated by hbm2java
 */
@Entity
@Table(name = "auth_function", catalog = "bos")
public class AuthFunction implements java.io.Serializable {

	private String id;
	private String name;
	private String code;
	private String description;
	private String page;
	private String generatemenu;
	private Integer zindex;
	private String pid;

	public AuthFunction() {
	}

	public AuthFunction(String id) {
		this.id = id;
	}

	public AuthFunction(String id, String name, String code, String description, String page, String generatemenu,
			Integer zindex, String pid) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.page = page;
		this.generatemenu = generatemenu;
		this.zindex = zindex;
		this.pid = pid;
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

	@Column(name = "page")
	public String getPage() {
		return this.page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Column(name = "generatemenu")
	public String getGeneratemenu() {
		return this.generatemenu;
	}

	public void setGeneratemenu(String generatemenu) {
		this.generatemenu = generatemenu;
	}

	@Column(name = "zindex")
	public Integer getZindex() {
		return this.zindex;
	}

	public void setZindex(Integer zindex) {
		this.zindex = zindex;
	}

	@Column(name = "pid", length = 32)
	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}