package com.bid.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public abstract class HibernateDAO<T> implements IHibernateDAO<T> {

	private Class<T> entityClass;

	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public HibernateDAO() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public T saveNew(T entity) {
		getSession().save(entity);
		return entity;
	}

	@Override
	public T saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public T getById(Long id) {
		return getSession().get(entityClass, id);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public void flush() {
		getSession().flush();
	}

	@Override
	public T merge(T entity) {
		getSession().merge(entity);
		return entity;
	}
	
	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
