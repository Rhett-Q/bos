package com.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.dao.UserDao;
import com.bos.domain.User;
import com.bos.service.UserService;
import com.bos.utils.MD5Utils;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(), password);
	}

	@Override
	public void editPasswd(String id, String password) {
		// TODO Auto-generated method stub
		password = MD5Utils.md5(password);
		userDao.excuteUpdate("user.editPassword", password, id);
	}

}
