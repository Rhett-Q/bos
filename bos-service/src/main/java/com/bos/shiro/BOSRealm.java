package com.bos.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.bos.dao.UserDao;
import com.bos.domain.User;

public class BOSRealm extends AuthorizingRealm {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken taken) throws AuthenticationException {
		UsernamePasswordToken mytaken = (UsernamePasswordToken) taken;
		String username = mytaken.getUsername();
		User user = userDao.findUserByName(username);
		if (user == null) return null;
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}


}
