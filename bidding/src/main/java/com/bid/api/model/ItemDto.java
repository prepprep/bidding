package com.bid.api.model;

import com.bid.domain.Category;

public class ItemDto extends AbstractDto {

	private String itemName;

	private Category category;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
