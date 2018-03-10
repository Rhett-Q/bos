package com.bos.web.action;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.domain.User;
import com.bos.service.UserService;
import com.bos.utils.BOSUtils;
import com.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	private String checkCode;
	@Autowired
	private UserService userService;
	
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	
	public String login() {
		String validateCode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if (StringUtils.isBlank(checkCode)) {
			this.addActionError("验证码输入为空！");
			return LOGIN;
		}
		if (!checkCode.equals(validateCode)) {
			this.addActionError("验证码输入错误！");
			return LOGIN;
		}
		User user = userService.login(model);
		if (user == null) {
			this.addActionError("用户名或密码错误！");
			return LOGIN;
		}
		ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
		return "HOME";
	}
	
	public String logout() {
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	
	public String editPassword() throws IOException {
		String f = "1";
		User user = BOSUtils.getLoginUser();
		try {
			userService.editPasswd(user.getId(), model.getPassword());
		} catch (Exception e) {
			f = "0";
			e.printStackTrace();
		}
		userService.editPasswd(user.getId(), model.getPassword());
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
	
}
