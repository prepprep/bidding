package com.bid.service.item;

import java.util.List;

import com.bid.api.model.ItemDto;

public interface IItemService {
	
	ItemDto getById(Long id);
	
	List<ItemDto> getAll();

}
