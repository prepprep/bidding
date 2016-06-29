package com.bid.dao.item;

import java.util.List;

import com.bid.dao.IHibernateDAO;
import com.bid.domain.Item;

public interface IItemDAO extends IHibernateDAO<Item> {

	List<Item> getAll();
}
