package com.bid.service.item;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bid.api.model.ItemDto;
import com.bid.dao.item.IItemDAO;
import com.bid.domain.Item;
import com.bid.service.BaseService;

@Service
@Transactional
public class ItemService extends BaseService implements IItemService {

	@Autowired
	private IItemDAO itemDao;
	
	@Override
	public ItemDto getById(Long id) {
		Item item = itemDao.getById(id);
		if (item == null)
			return null;
		return toDto(item);
	}

	@Override
	public List<ItemDto> getAll() {
		return toDtoList(itemDao.getAll());
	}

}
