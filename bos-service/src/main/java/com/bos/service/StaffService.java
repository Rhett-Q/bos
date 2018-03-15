package com.bos.service;

import com.bos.domain.Staff;
import com.bos.utils.PageBean;

public interface StaffService {

	public void save(Staff model);

	public void pageQuery(PageBean pageBean);

	public void deleteBatch(String ids);

	public Staff findById(String id);

	public void update(Staff staff);

}
