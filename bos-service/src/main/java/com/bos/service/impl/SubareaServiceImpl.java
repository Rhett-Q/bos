package com.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.dao.SubareaDao;
import com.bos.domain.Subarea;
import com.bos.service.SubareaService;
import com.bos.utils.PageBean;
@Service
@Transactional
public class SubareaServiceImpl implements SubareaService {

	@Autowired
	private SubareaDao subareaDao;
	
	@Override
	public void add(Subarea model) {
		// TODO Auto-generated method stub
		subareaDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		subareaDao.pageQuery(pageBean);
	}

	@Override
	public List<Subarea> findAll() {
		// TODO Auto-generated method stub
		return subareaDao.findAll();
	}

	@Override
	public List<Subarea> findNotAssociation() {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Subarea.class);
		criteria.add(Restrictions.isNull("decidedzone"));
		return subareaDao.findByCriteria(criteria);
	}

	@Override
	public List<Subarea> findListByDecidedzoneId(String decidedzoneId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Subarea.class);
		criteria.add(Restrictions.eq("decidedzone.id", decidedzoneId));
		List<Subarea> list = subareaDao.findByCriteria(criteria);
		return list;
	}

}
