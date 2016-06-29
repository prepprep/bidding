package com.bid.service.catalog;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bid.api.model.CatalogDto;
import com.bid.dao.catalog.ICatalogDAO;
import com.bid.domain.Catalog;
import com.bid.service.BaseService;

@Service
@Transactional
public class CatalogService extends BaseService implements ICatalogService {

	@Autowired
	private ICatalogDAO catalogDao;
	
	@Override
	public List<CatalogDto> getAll() {
		List<Catalog> catalogs = catalogDao.getAll();
		if (!CollectionUtils.isEmpty(catalogs))
			return toDtoList(catalogs);
		return null;
	}

	@Override
	public CatalogDto getById(Long id) {
		Catalog catalog = catalogDao.getById(id);
		if(catalog != null) 
			return toDto(catalog);
		return null;
	}

}
