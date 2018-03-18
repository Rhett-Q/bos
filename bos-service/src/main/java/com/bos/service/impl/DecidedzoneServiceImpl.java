package com.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.dao.DecidedzoneDao;
import com.bos.dao.SubareaDao;
import com.bos.domain.Decidedzone;
import com.bos.domain.Subarea;
import com.bos.service.DecidedzoneService;
import com.bos.utils.PageBean;
import com.bos.service.DecidedzoneService;
@Service
@Transactional
public class DecidedzoneServiceImpl implements DecidedzoneService {
	@Autowired
	private DecidedzoneDao decidedzoneDao;
	@Autowired
	private SubareaDao subareaDao;
	@Override
	public void save(Decidedzone model, String[] subareaid) {
		decidedzoneDao.save(model);
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			subarea.setDecidedzone(model);//外键由多的一方维护
		}
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		decidedzoneDao.pageQuery(pageBean);
	}

}
