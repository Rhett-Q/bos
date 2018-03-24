package com.bos.web.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.crm.Customer;
import com.bos.crm.CustomerService;
import com.bos.domain.Noticebill;
import com.bos.service.NoticebillService;
import com.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill> {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private NoticebillService noticebillService;
	
	public String findCustomerByTelephone() throws IOException {
		String telephone = model.getTelephone();
		Customer customer = customerService.findCustomerByTelephone(telephone);
		objectToJson(customer, new String[]{});
		return NONE;
	}
	
	public String add() {
		noticebillService.save(model);
		return "noticebill_add";
	}
	
}
