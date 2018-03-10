package com.bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.bos.dao.base.BaseDao;

/*
 * 持久层通用实现
 */

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	private Class<T> entityClass;
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	public BaseDaoImpl() {
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] arguments = superclass.getActualTypeArguments();
		entityClass = (Class<T>) arguments[0];
	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public T findById(Serializable id) {
		this.getHibernateTemplate().get(entityClass, id);
		return null;
	}

	@Override
	public List<T> findAll() {
		String hql = "from " + entityClass.getSimpleName();
		List<T> list = (List<T>) this.getHibernateTemplate().find(hql);
		return list;
	}
	
	public void excuteUpdate(String queryName, Object...objects) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.getNamedQuery(queryName);
		int i = 0;
		for (Object obj : objects) {
			query.setParameter(i++, obj);
		}
		query.executeUpdate();
	}
	
}
