package com.bid.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Item extends AbstractEntity {

	private static final long serialVersionUID = 7827911272737534665L;

	@Size(max=50)
	private String itemName;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_category_item"))
	@JsonBackReference
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
