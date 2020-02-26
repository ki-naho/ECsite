package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;

	public String execute() {
		String result = "login";

		//ログイン済み判定を行う。ログインしている場合は商品画面へ遷移させる
		//DBから取得した商品情報をセッションに格納している。次のjspページで使うから
		if(session.containsKey("login_user_id")) {
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			session.put("item_stock", buyItemDTO.getItemStock());
			result = SUCCESS;
		}
		return result;
	}

	public Map<String,Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}
