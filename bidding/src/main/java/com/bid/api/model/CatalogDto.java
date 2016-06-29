package com.bid.api.model;

import java.util.List;

import com.bid.domain.Category;

public class CatalogDto extends AbstractDto {

	private String catalogName;

	private List<Category> categories;

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
