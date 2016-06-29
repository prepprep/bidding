package com.bid.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bid.api.model.CatalogDto;
import com.bid.service.catalog.ICatalogService;

@RestController
public class CatalogController {

	@Autowired
	private ICatalogService catalogService;

	@RequestMapping("/catalog/all")
	public ResponseEntity<List<CatalogDto>> getAll() {
		List<CatalogDto> catalog = catalogService.getAll();
		return new ResponseEntity<List<CatalogDto>>(catalog, HttpStatus.OK);
	}
	
	@RequestMapping("/catalog/{id}")
	public ResponseEntity<CatalogDto> getById(@PathVariable Long id) {
		CatalogDto catalog = catalogService.getById(id);
		return new ResponseEntity<CatalogDto>(catalog, HttpStatus.OK);
	}
	
}
