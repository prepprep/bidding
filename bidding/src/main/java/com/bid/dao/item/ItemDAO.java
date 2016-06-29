package com.bid.dao.item;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bid.dao.HibernateDAO;
import com.bid.domain.Item;

@Repository
public class ItemDAO extends HibernateDAO<Item> implements IItemDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAll() {
		String stmt = "select i from Item i";
		Query query = getSession().createQuery(stmt);
		return query.list();
	}
}
