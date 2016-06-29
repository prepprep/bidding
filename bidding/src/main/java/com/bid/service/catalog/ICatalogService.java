package com.bid.service.catalog;

import java.util.List;

import com.bid.api.model.CatalogDto;

public interface ICatalogService {
	
	List<CatalogDto> getAll();
	
	CatalogDto getById(Long id);

}
