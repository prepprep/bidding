package com.bid.dbinit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bid.dao.address.IAddressDAO;
import com.bid.dao.catalog.ICatalogDAO;
import com.bid.dao.category.ICategoryDAO;
import com.bid.dao.item.IItemDAO;
import com.bid.dao.user.IUserDAO;
import com.bid.domain.Address;
import com.bid.domain.Catalog;
import com.bid.domain.Category;
import com.bid.domain.Item;
import com.bid.domain.User;

@Service
@Transactional
public class DBinitializeService implements IDBinitializerService {

	@Autowired
	private IUserDAO userDao;

	@Autowired
	private IAddressDAO addressDao;
	
	@Autowired
	private ICategoryDAO categoryDao;
	
	@Autowired
	private ICatalogDAO catalogDao;

	@Autowired
	private IItemDAO itemDao;
	
	@Override
	public void init() {
		createUser();
		createAddress();
		createCatalog();
		createCategory();
		createItem();
	}
	
	private void createCatalog() {
		for (int i = 0; i < 3; i++) {
			catalogDao.saveNew(catalog());
		}
	}
	
	private Catalog catalog() {
		Catalog catalog = new Catalog();
		catalog.setCatalogName(DbFiller.getCatalogName());
		return catalog;
	}
	
	private void createCategory() {
		for (int i = 0; i < 3; i++) {
			categoryDao.saveNew(category());
		}
	}
	
	private Category category() {
		Category category = new Category();
		category.setCategoryName(DbFiller.getCategoryName());
		category.setCatalog(catalogDao.getById(1l));
		return category;
	}
	
	private void createItem() {
		for (int i = 0; i < 3; i++) {
			itemDao.saveNew(item());
		}
	}
	
	private Item item() {
		Item item = new Item();
		item.setItemName(DbFiller.getItemName());
		item.setCategory(categoryDao.getById(1l));
		return item;
	}

	private void createUser() {
		for (int i = 0; i < 3; i++) {
			userDao.saveNew(user());
		}
	}

	private User user() {
		User user = new User();
		user.setUsername(DbFiller.getFirstLastName());
		user.setPassword(DbFiller.getPassword());
		user.setEmail(DbFiller.getEmail());
		user.setMobile(DbFiller.getPhone());
		return user;
	}

	private void createAddress() {
		for (int i = 0; i < 3; i++) {
			addressDao.saveNew(address());
		}
	}

	private Address address() {
		Address address = new Address();
		address.setStreetAddress(DbFiller.getAddressLine());
		address.setCityAddress(DbFiller.getAddressLine());
		address.setUser(userDao.getById(1l));
		return address;
	}

}
