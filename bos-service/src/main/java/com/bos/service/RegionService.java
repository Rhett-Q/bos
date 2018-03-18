package com.bos.service;

import java.util.List;

import com.bos.domain.Region;
import com.bos.utils.PageBean;

public interface RegionService {

	void saveBatch(List<Region> regionList);

	void pageQuery(PageBean pageBean);

	List findAll();

	List findAllByQ(String q);


}
