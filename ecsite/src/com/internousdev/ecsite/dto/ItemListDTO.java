package com.internousdev.ecsite.dto;

public class ItemListDTO {

	private String id;
	private String itemName;
	private String itemPrice;
	private String number;
	private String insert_date;
	private String update_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id=id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName=itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice=itemPrice;
	}

	public String getNumber () {
		return number;
	}

	public void setNumber(String number) {
		this.number=number;
	}

	public String getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(String insert_date) {
		this.insert_date=insert_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date=update_date;
	}
}
