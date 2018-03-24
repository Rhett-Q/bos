package com.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.crm.Customer;
import com.bos.crm.CustomerService;
import com.bos.domain.Decidedzone;
import com.bos.service.DecidedzoneService;
import com.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone> {
	@Autowired
	private DecidedzoneService decidedzoneService;
	
	private String[] subareaid;
	
	private List<Integer> customerIds;
	
	@Autowired
	private CustomerService proxy;
	
	public void setCustomerIds(List<Integer> customerIds) {
		this.customerIds = customerIds;
	}
	
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
	
	public String findListNotAssociation() throws IOException {
		List<Customer> list = proxy.findListNotAssociation();
		objectToJson(list, new String[]{});
		return NONE;
	}
	
	public String findListHasAssociation() throws IOException {
		String id = model.getId();
		List<Customer> list = proxy.findListHasAssociation(id);
		objectToJson(list, new String[]{});
		return NONE;
	}
	
	public void assigncustomerstodecidedzone() {
		proxy.assoigncustomerstodecideczone(model.getId(), customerIds);
		return "list";
	}
	
}
