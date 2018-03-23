package com.bos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bos.dao.UserDao;
import com.bos.dao.base.impl.BaseDaoImpl;
import com.bos.domain.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.username = ? and u.password = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username, password);
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from where username = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(sql, username);
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

}
