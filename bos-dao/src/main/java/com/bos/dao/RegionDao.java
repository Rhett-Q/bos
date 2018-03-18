package com.bos.dao;

import java.util.List;

import com.bos.dao.base.BaseDao;
import com.bos.domain.Region;

public interface RegionDao extends BaseDao<Region> {

	List findAllByQ(String q);
	
}
