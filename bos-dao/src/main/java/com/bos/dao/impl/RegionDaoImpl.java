package com.bos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bos.dao.RegionDao;
import com.bos.dao.base.impl.BaseDaoImpl;
import com.bos.domain.Region;
import com.bos.utils.PageBean;
@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements RegionDao {

	@Override
	public List findAllByQ(String q) {
		// TODO Auto-generated method stub
		String hql = "FROM Region r WHERE r.provine LIKE ? OR r.city LIKE ? OR r.district LIKE ? OR r.shortcode LIKE ? OR r.citycode LIKE ? ";
		List<Region> list = (List<Region>) this.getHibernateTemplate().find(hql, "%" + q + "%", "%" + q + "%", "%" + q + "%", "%" + q + "%", "%" + q + "%");
		return list;
	}

}
