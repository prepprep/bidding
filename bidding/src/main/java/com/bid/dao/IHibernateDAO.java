package com.bid.dao;

import java.util.List;

public interface IHibernateDAO<T> {

	T saveNew(T entity);

	T saveOrUpdate(T entity);

	T getById(Long id);

	T merge(T entity);

	List<T> getAll();

	void delete(T entity);

	void flush();

}
