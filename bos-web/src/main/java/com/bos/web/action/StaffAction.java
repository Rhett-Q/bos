package com.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.domain.Staff;
import com.bos.service.StaffService;
import com.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	
	@Autowired
	private StaffService staffService;
	
	public String add() {
		staffService.save(model);
		return "list";
	}
}
