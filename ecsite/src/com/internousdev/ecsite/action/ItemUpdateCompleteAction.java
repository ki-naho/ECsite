package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemUpdateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemUpdateCompleteAction extends ActionSupport implements SessionAware {

	private String id;
	private String message;
	private Map<String,Object> session;

	public String execute() throws SQLException {

		ItemUpdateCompleteDAO dao = new ItemUpdateCompleteDAO();

		int res = dao.itemUpdate(
				session.get("reItemName").toString(),
				session.get("reItemPrice").toString(),
				session.get("reItemNumber").toString(),
				id
			);

		if (res>0) {
			setMessage("商品の情報を正しく更新しました。");
		} else {
			setMessage("商品の情報の更新に失敗しました。");
		}

		String result = SUCCESS;
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id=id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message=message;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}
