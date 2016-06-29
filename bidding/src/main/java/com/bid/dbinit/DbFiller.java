package com.bid.dbinit;

public class DbFiller {

	// static data
	private static final String[] CATALOG_NAME = { "electronic", "car", "house" };
	private static final String[] TYPE = { "one", "two", "three" };

	private static final String[] CATEGORY_NAME = { "computer", "tablet", "laptop" };
	private static final String[] ITEM_NAME = { "Macbook", "BMW", "semi-house" };

	private static final String[] FIRST_LAST_NAME = { "Tom", "Micheal", "Angelica" };
	private static final String[] PASSWORD = { "123", "456", "789" };
	private static final String[] PHONE = { "087 392 123", "087 392 456", "087 392 789" };
	private static final String[] EMAIL = { "abc@example.com", "def@fake.com", "xxx@kai.com" };

	private static final String[] ADDRESS_LINE = { "57", "Renmin Road", "HuaLong" };
	private static final String[] CITY = { "Beijing", "Henan", "Zhejiang" };
	private static final String[] COUNTY = { "Kildare", "Cork", "Galway" };
	private static final String[] COUNTRY = { "Ireland", "China", "America" };

	// data initialize
	private static Data<String> catalogName = dataFactory(CATALOG_NAME);
	private static Data<String> categoryName = dataFactory(CATEGORY_NAME);
	private static Data<String> type = dataFactory(TYPE);
	private static Data<String> itemName = dataFactory(ITEM_NAME);
	private static Data<String> firstLastName = dataFactory(FIRST_LAST_NAME);
	private static Data<String> password = dataFactory(PASSWORD);
	private static Data<String> phone = dataFactory(PHONE);
	private static Data<String> email = dataFactory(EMAIL);
	private static Data<String> addressLine = dataFactory(ADDRESS_LINE);
	private static Data<String> city = dataFactory(CITY);
	private static Data<String> county = dataFactory(COUNTY);
	private static Data<String> country = dataFactory(COUNTRY);

	public static class Data<T> {
		private int index;

		private T[] data;

		public Data(T[] data) {
			this.data = data;
		}

		public T next() {
			if (index > data.length - 1) {
				index = 0;
			}

			T el = data[index];
			index++;

			return el;
		}
	}
	
	public static Data<String> dataFactory(String[] data) {
		return new Data<String>(data);
	}
	
	public static String getCatalogName() {
		return catalogName.next();
	}

	public static String getCategoryName() {
		return categoryName.next();
	}

	public static String getType() {
		return type.next();
	}

	public static String getItemName() {
		return itemName.next();
	}

	public static String getFirstLastName() {
		return firstLastName.next();
	}

	public static String getPassword() {
		return password.next();
	}

	public static String getPhone() {
		return phone.next();
	}

	public static String getEmail() {
		return email.next();
	}

	public static String getAddressLine() {
		return addressLine.next();
	}

	public static String getCity() {
		return city.next();
	}

	public static String getCounty() {
		return county.next();
	}

	public static String getCountry() {
		return country.next();
	}

}
