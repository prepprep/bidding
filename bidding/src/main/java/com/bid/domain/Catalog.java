package com.bid.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Catalog extends AbstractEntity {

	private static final long serialVersionUID = -3237893572835480225L;

	@Size(max=50)
	private String catalogName;

	@OneToMany(mappedBy = "catalog")
	@JsonManagedReference
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
