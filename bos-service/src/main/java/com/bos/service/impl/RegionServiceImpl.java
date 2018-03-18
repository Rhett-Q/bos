package com.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.dao.RegionDao;
import com.bos.domain.Region;
import com.bos.service.RegionService;
import com.bos.utils.PageBean;
@Service
@Transactional
public class RegionServiceImpl implements RegionService {
	
	@Autowired
	private RegionDao regionDao;
	
	@Override
	public void saveBatch(List<Region> regionList) {
		// TODO Auto-generated method stub
		for (Region region : regionList) {
			regionDao.saveOrUpdate(region);
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		regionDao.pageQuery(pageBean);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return regionDao.findAll();
	}

	@Override
	public List findAllByQ(String q) {
		// TODO Auto-generated method stub
		return regionDao.findAllByQ(q);
	}
	
}
