package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	private Map<String ,Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public String execute() throws SQLException {
		int count = buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString());

		//insertされたら、update文を実行
		if(count > 0) {						//↓　Object型 → String型   → int型                                                          ↓ Object型　→　　String型
			buyItemCompleteDAO.updateItemInfo(Integer.parseInt(session.get("count").toString()), session.get("id").toString());
		}


		String result=SUCCESS;
		return result;
	}



	//thisはなくてもあっても。統一
	public Map<String ,Object> getSession() {
		return session;
	}

	public void setSession(Map<String,Object> session) {
		this.session=session;
	}


}
