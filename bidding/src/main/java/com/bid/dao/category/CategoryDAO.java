package com.bid.dao.category;

import org.springframework.stereotype.Repository;

import com.bid.dao.HibernateDAO;
import com.bid.domain.Category;

@Repository
public class CategoryDAO extends HibernateDAO<Category> implements ICategoryDAO {

}
