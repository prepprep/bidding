package com.bid.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bid.api.model.ItemDto;
import com.bid.service.item.IItemService;

@RestController
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	@RequestMapping(path = "/item/all", method=RequestMethod.GET)
	public ResponseEntity<List<ItemDto>> getAllItems() {
		List<ItemDto> items = itemService.getAll();
		return new ResponseEntity<List<ItemDto>>(items, HttpStatus.OK);
	}

}
