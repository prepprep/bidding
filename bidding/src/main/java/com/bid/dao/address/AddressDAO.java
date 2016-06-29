package com.bid.dao.address;

import org.springframework.stereotype.Repository;

import com.bid.dao.HibernateDAO;
import com.bid.domain.Address;

@Repository
public class AddressDAO extends HibernateDAO<Address> implements IAddressDAO {

}
