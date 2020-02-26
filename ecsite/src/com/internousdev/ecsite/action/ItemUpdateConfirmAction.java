package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemUpdateConfirmAction extends ActionSupport implements SessionAware {

	private String id;
	private String reItemName;
	private String reItemPrice;
	private String reItemNumber;
	private Map<String , Object> session;

	private String errorMessage;

	public String execute() throws SQLException {

		String result =SUCCESS;

		if(reItemName.equals(session.get("itemName")) && reItemPrice.equals(session.get("itemPrice")) && reItemNumber.equals(session.get("itemNumber"))) {
					setErrorMessage("情報が変更されていません。");
					result =ERROR;

		}

		session.put("reItemName", reItemName);
		session.put("reItemPrice", reItemPrice);
		session.put("reItemNumber", reItemNumber);

		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id=id;
	}

	public String getReItemName() {
		return reItemName;
	}

	public void setReItemName(String reItemName) {
		this.reItemName=reItemName;
	}

	public String getReItemPrice() {
		return reItemPrice;
	}

	public void setReItemPrice(String reItemPrice) {
		this.reItemPrice=reItemPrice;
	}

	public String getReItemNumber() {
		return reItemNumber;
	}

	public void setReItemNumber(String reItemNumber) {
		this.reItemNumber=reItemNumber;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}

}
