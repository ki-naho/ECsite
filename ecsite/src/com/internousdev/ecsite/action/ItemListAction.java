package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private List<ItemListDTO> itemListDTOList = new ArrayList<ItemListDTO>();

	public String execute() throws SQLException{


		ItemListDAO dao = new ItemListDAO();
		itemListDTOList = dao.selectItemList();


		String result = SUCCESS;
		return result;
	}

	public Map<String,Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

	public List<ItemListDTO> getItemListDTOList (){
		return itemListDTOList;
	}

	public void setItemListDTOList(List<ItemListDTO> itemListDTOList) {
		this.itemListDTOList=itemListDTOList;
	}

}
