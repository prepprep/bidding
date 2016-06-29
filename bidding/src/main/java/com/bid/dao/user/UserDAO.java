package com.bid.dao.user;

import org.springframework.stereotype.Repository;

import com.bid.dao.HibernateDAO;
import com.bid.domain.User;

@Repository
public class UserDAO extends HibernateDAO<User> implements IUserDAO {

}
