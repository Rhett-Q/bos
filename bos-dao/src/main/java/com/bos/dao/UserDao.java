package com.bos.dao;

import com.bos.dao.base.BaseDao;
import com.bos.domain.User;

public interface UserDao extends BaseDao<User> {
	User findUserByUsernameAndPassword(String username, String password);
}
