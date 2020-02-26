package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport{

	private String message;

	public String execute() throws SQLException{


		ItemListDeleteCompleteDAO dao = new ItemListDeleteCompleteDAO();

		int res = dao.deleteItemList(); //daoの実行
		if (res >0) {
			setMessage("商品情報を正しく削除しました。");
		} else {
			setMessage("商品情報の削除に失敗しました。");
		}

		String result = SUCCESS;
		return result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message=message;
	}
}
