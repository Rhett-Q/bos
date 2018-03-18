package com.bos.service;

import com.bos.domain.Decidedzone;
import com.bos.utils.PageBean;

public interface DecidedzoneService {

	void save(Decidedzone model, String[] subareaid);

	void pageQuery(PageBean pageBean);

}
