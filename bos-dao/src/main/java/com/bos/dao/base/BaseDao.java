package com.bos.dao.base;

import java.io.Serializable;
import java.util.List;

import com.bos.utils.PageBean;

/*
 * 持久层通用接口
 */
public interface BaseDao<T> {
	
	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
	public void excuteUpdate(String queryName, Object...objects);
	public void pageQuery(PageBean pageBean);
	public void saveOrUpdate(T entity);
}
