package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemCreateCompleteAction extends ActionSupport implements SessionAware {

	private String itemName;
	private String itemPrice;
	private String number;
	private Map<String,Object> session;
	private ItemCreateCompleteDAO dao = new ItemCreateCompleteDAO();

	public String execute() throws SQLException{

		dao.createItem(
			session.get("itemName").toString(),
			session.get("itemPrice").toString(),
			session.get("number").toString()
		);

		String result = SUCCESS;

		return result;
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
		this.itemPrice= itemPrice;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number=number;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
