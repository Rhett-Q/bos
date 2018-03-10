package com.bos.service;

import com.bos.domain.User;

public interface UserService {
	User login(User user);

	void editPasswd(String id, String password);
}
