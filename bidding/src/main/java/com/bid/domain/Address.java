package com.bid.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address extends AbstractEntity {

	private static final long serialVersionUID = -7083949108890299349L;

	@Column(length = 200, nullable = false)
	private String streetAddress;

	@Column(length = 200)
	private String cityAddress;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_user_address"))
	private User user;

	public Address() {
	}

	public Address(String streetAddress, String cityAddress, User user) {
		super();
		this.streetAddress = streetAddress;
		this.cityAddress = cityAddress;
		this.user = user;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCityAddress() {
		return cityAddress;
	}

	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cityAddress == null) ? 0 : cityAddress.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (cityAddress == null) {
			if (other.cityAddress != null)
				return false;
		} else if (!cityAddress.equals(other.cityAddress))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	

}
