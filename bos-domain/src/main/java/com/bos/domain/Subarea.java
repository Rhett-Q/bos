package com.bos.domain;
// Generated 2018-3-22 20:02:41 by Hibernate Tools 3.6.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Subarea generated by hbm2java
 */
@Entity
@Table(name = "subarea", catalog = "bos")
public class Subarea implements java.io.Serializable {

	private String id;
	private Decidedzone decidedzone;
	private Region region;
	private String addresskey;
	private String startnum;
	private String endnum;
	private Character single;
	private String position;
	
	public String getSubareaid() {
		return id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Decidedzone getDecidedzone() {
		return decidedzone;
	}
	public void setDecidedzone(Decidedzone decidedzone) {
		this.decidedzone = decidedzone;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public String getAddresskey() {
		return addresskey;
	}
	public void setAddresskey(String addresskey) {
		this.addresskey = addresskey;
	}
	public String getStartnum() {
		return startnum;
	}
	public void setStartnum(String startnum) {
		this.startnum = startnum;
	}
	public String getEndnum() {
		return endnum;
	}
	public void setEndnum(String endnum) {
		this.endnum = endnum;
	}
	public Character getSingle() {
		return single;
	}
	public void setSingle(Character single) {
		this.single = single;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	
}
