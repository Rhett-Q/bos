package com.bos.domain;
// Generated 2018-3-22 20:02:41 by Hibernate Tools 3.6.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Workbill generated by hbm2java
 */
@Entity
@Table(name = "workbill", catalog = "bos")
public class Workbill implements java.io.Serializable {

	private String id;
	private Noticebill noticebill;
	private String type;
	private String pickstate;
	private Date buildtime;
	private Integer attachbilltimes;
	private String remark;
	private Staff staff;
	
	public final static String TYPE_1 = "新单";
	public final static String TYPE_2 = "追单";
	public final static String TYPE_3 = "改单";
	public final static String TYPE_4 = "销单";
	
	public final static String PICKSTATE_NO = "未取件";
	public final static String PICKSTATE_RUNNING = "取件中";
	public final static String PICKSTATE_YES = "已取件";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Noticebill getNoticebill() {
		return noticebill;
	}
	public void setNoticebill(Noticebill noticebill) {
		this.noticebill = noticebill;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPickstate() {
		return pickstate;
	}
	public void setPickstate(String pickstate) {
		this.pickstate = pickstate;
	}
	public Date getBuildtime() {
		return buildtime;
	}
	public void setBuildtime(Date buildtime) {
		this.buildtime = buildtime;
	}
	public Integer getAttachbilltimes() {
		return attachbilltimes;
	}
	public void setAttachbilltimes(Integer attachbilltimes) {
		this.attachbilltimes = attachbilltimes;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}
