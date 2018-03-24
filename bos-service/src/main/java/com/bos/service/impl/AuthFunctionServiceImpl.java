package com.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.dao.AuthFunctionDao;
import com.bos.domain.AuthFunction;
import com.bos.service.AuthFunctionService;
@Service
@Transactional
public class AuthFunctionServiceImpl implements AuthFunctionService {

	@Autowired
	private AuthFunctionDao authFunctionDao; 
	
	@Override
	public List<AuthFunction> findAll() {
		// TODO Auto-generated method stub
		return authFunctionDao.findAll();
	}

}
