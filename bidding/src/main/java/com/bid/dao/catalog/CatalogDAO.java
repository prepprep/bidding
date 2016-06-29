package com.bid.dao.catalog;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bid.dao.HibernateDAO;
import com.bid.domain.Catalog;

@Repository
public class CatalogDAO extends HibernateDAO<Catalog> implements ICatalogDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Catalog> getAll() {
		String stmt = "from Catalog cata";
		Query query = getSession().createQuery(stmt);
		return query.list();
	}
	
	@Override
	public Catalog getById(Long id) {
		String stmt = "from Catalog cat where cat.id=:id";
		Query query = getSession().createQuery(stmt);
		query.setParameter("id", id);
		return (Catalog) query.uniqueResult();
	}

}
