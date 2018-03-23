package com.bos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.bos.dao.WorkbillDao;
import com.bos.dao.base.impl.BaseDaoImpl;
import com.bos.domain.Workbill;
import com.bos.utils.PageBean;
@Repository
public class WorkbillDaoImpl extends BaseDaoImpl<Workbill> implements WorkbillDao {

}
