package com.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.domain.AuthFunction;
import com.bos.service.AuthFunctionService;
import com.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class AuthFunctionAction extends BaseAction<AuthFunction> {
	
	@Autowired
	private AuthFunctionService authFunctionService;
	
	public String listajax() throws IOException {
		List<AuthFunction> list = authFunctionService.findAll();
		objectToJson(list, new String[]{"parentFuction", "relos", "children"});
		return NONE;
	}
	
}
