package com.bos.web.action;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bos.crm.CustomerService;
import com.bos.domain.User;
import com.bos.service.UserService;
import com.bos.utils.BOSUtils;
import com.bos.utils.MD5Utils;
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
		//User user = userService.login(model);
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken(model.getUsername(), MD5Utils.md5(model.getPassword()));
		try {
			subject.login(token);
			User user = (User) subject.getPrincipal();
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//return LOGIN;
		}
//		if (user == null) {
//			this.addActionError("用户名或密码错误！");
//			return LOGIN;
//		}
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
