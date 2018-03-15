package com.bos.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.dao.StaffDao;
import com.bos.domain.Staff;
import com.bos.service.StaffService;
import com.bos.utils.PageBean;
@Service
@Transactional
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDao staffDao;
	
	@Override
	public void save(Staff model) {
		// TODO Auto-generated method stub
		staffDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		staffDao.pageQuery(pageBean);
	}

	@Override
	public void deleteBatch(String ids) {
		// TODO Auto-generated method stub
		if (StringUtils.isNotBlank(ids)) {
			String[] staffIds = ids.split(",");
			for (String id : staffIds) {
				staffDao.excuteUpdate("staff.delete", id);
			}
		}
	}

	@Override
	public Staff findById(String id) {
		// TODO Auto-generated method stub
		return staffDao.findById(id);
	}

	@Override
	public void update(Staff staff) {
		// TODO Auto-generated method stub
		staffDao.update(staff);
	}

}
