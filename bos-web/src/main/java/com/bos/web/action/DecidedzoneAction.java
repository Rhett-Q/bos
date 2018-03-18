package com.bos.web.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.domain.Decidedzone;
import com.bos.service.DecidedzoneService;
import com.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone> {
	@Autowired
	private DecidedzoneService decidedzoneService;
	
	private String[] subareaid;
	
	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	
	public String add() {
		decidedzoneService.save(model, subareaid);
		return "list";
	}
	
	public String pageQuery() throws IOException {
		decidedzoneService.pageQuery(pageBean);
		objectToJson(pageBean, new String[]{"currentPage", "detachedCriteria", "pageSize", "subareas"});
		return NONE;
	}
	
}
