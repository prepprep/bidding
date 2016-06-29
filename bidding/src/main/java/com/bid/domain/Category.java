package com.bid.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Category extends AbstractEntity {

	private static final long serialVersionUID = -5967668765008001139L;

	@Size(max = 100)
	private String categoryName;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_catalog_category"))
	@JsonBackReference
	private Catalog catalog;

	@OneToMany( mappedBy = "category")
	@JsonManagedReference
	private List<Item> items;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
