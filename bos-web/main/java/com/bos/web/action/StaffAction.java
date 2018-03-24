package com.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.domain.Staff;
import com.bos.service.StaffService;
import com.bos.utils.PageBean;
import com.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	//分页接受变量
	private int page;
	private int rows;
	//批量删除ids
	private String ids;
	
	public void setIds(String ids) {
		this.ids = ids;
	}
	public void setPage(int page) {
		pageBean.setCurrentPage(page);
	}
	public void setRows(int rows) {
		pageBean.setPageSize(rows);
	}
	@Autowired
	private StaffService staffService;
	
	public String add() {
		staffService.save(model);
		return "list";
	}
	
	public String pageQuery() throws IOException {
		staffService.pageQuery(pageBean);
		objectToJson(pageBean, new String[]{"currentPage", "detachedCriteria", "pageSize"});
		return NONE;
	}
	@RequiresPermissions("staff-delete")
	public String deleteBatch() {
		staffService.deleteBatch(ids);
		return "list";
	}
	
	public String edit() {
		Staff staff = staffService.findById(model.getId());
		System.out.println(model.getName());
		System.out.println(model.getHaspda());
		staff.setHaspda(model.getHaspda());
		staff.setName(model.getName());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staff.setTelephone(model.getTelephone());
		staffService.update(staff);
		return "list";
	}
	
	public String ajaxList() throws IOException {
		List<Staff> list = staffService.findNotDelete();
		objectToJson(list, new String[]{"decidedzone"});
		return NONE;
	}
	
}
