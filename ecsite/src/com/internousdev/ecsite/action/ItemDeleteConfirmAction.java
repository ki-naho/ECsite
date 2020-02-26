package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDetailsDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteConfirmAction extends ActionSupport implements SessionAware {

	private String id;
	private ItemListDTO itemDetailsDTO;
	private Map<String , Object> session;

	public String execute() throws SQLException {

		String result = ERROR;

		ItemDetailsDAO dao =new ItemDetailsDAO();
		itemDetailsDTO  = dao.selectItemInfo(id);



		result = SUCCESS;

		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id=id;
	}

	public ItemListDTO getItemDetailsDTO() {
		return itemDetailsDTO;
	}

	public void setItemDetailsDTO (ItemListDTO itemDetailsDTO) {
		this.itemDetailsDTO = itemDetailsDTO;
	}

	public Map<String,Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
}
