package com.bos.service.impl;

import java.sql.Timestamp;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.crm.CustomerService;
import com.bos.dao.DecidedzoneDao;
import com.bos.dao.NoticebillDao;
import com.bos.dao.WorkbillDao;
import com.bos.domain.Decidedzone;
import com.bos.domain.Noticebill;
import com.bos.domain.Staff;
import com.bos.domain.User;
import com.bos.domain.Workbill;
import com.bos.service.NoticebillService;
import com.bos.utils.BOSUtils;
@Service
@Transactional
public class NoticebillServiceImpl implements NoticebillService {
	
	@Autowired
	private NoticebillDao noticebillDao;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private DecidedzoneDao decidedzoneDao;
	@Autowired
	private WorkbillDao workbillDao;
	
	@Override
	public void save(Noticebill model) {
		User user = BOSUtils.getLoginUser();
		model.setUser(user);
		noticebillDao.save(model);
		String pickaddress = model.getPickaddress();
		String decidedzoneId= customerService.findDecidedzoneIdByAddress(pickaddress);
		if (decidedzoneId != null) {
			Decidedzone decidedzone = decidedzoneDao.findById(decidedzoneId);
			Staff staff = decidedzone.getStaff();
			model.setStaff(staff);
			model.setOrdertype(Noticebill.ORDERTYPE_AUTO);
			Workbill workbill = new Workbill();
			workbill.setAttachbilltimes(0);
			workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));
			workbill.setNoticebill(model);
			workbill.setPickstate(workbill.PICKSTATE_NO);
			workbill.setRemark(model.getRemark());
			workbill.setStaff(staff);
			workbill.setType(workbill.TYPE_1);
			workbillDao.save(workbill);
		} else {
			model.setOrdertype(Noticebill.ORDERTYPE_MAN);
		}
	}

}
