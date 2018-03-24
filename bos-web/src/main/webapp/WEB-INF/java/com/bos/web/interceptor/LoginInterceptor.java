package com.bos.web.interceptor;

import com.bos.domain.User;
import com.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		User user = BOSUtils.getLoginUser();
		if (user == null) {
			return "login";
		}
		return invocation.invoke();
	}

}
