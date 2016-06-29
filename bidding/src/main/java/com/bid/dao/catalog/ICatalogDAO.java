package com.bid.dao.catalog;

import java.util.List;

import com.bid.dao.IHibernateDAO;
import com.bid.domain.Catalog;

public interface ICatalogDAO extends IHibernateDAO<Catalog>{

	List<Catalog> getAll();
	
	Catalog getById(Long id);
}
