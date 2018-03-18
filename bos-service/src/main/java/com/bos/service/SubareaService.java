package com.bos.service;

import java.util.List;

import com.bos.domain.Subarea;
import com.bos.utils.PageBean;

public interface SubareaService {

	void add(Subarea model);

	void pageQuery(PageBean pageBean);

	List<Subarea> findAll();

	List<Subarea> findNotAssociation();

}
