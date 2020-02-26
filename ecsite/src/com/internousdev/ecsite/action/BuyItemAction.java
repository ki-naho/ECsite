package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private int count;
	private String pay;
	private String errorMessage;

	public String execute() {

		String result = SUCCESS;

		/*　　在庫がなくなる程は買えないようにするには・・・
		 * 商品情報をselectするメソッドは HomeActionでBuyItemDAOを呼び出している。
		 * 在庫数もslectして、その数値をsessionでここまで共有。在庫数=(session("item_stock") /*/
		int itemStock = Integer.parseInt(session.get("item_stock").toString());
		if (count > itemStock) {
			setErrorMessage("在庫が足りません。");
			result = ERROR;
		}

		//購入個数
		session.put("count", count);

		//購入個数(count)×値段(buyItem_price)で合計金額(total_price)を設定する
		//Object型→String型→Int型　（一度String型に直さないといけない)
		int intCount= Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price", intCount*intPrice);

		String payment;
		if(pay.equals("1")) {
			payment = "現金払い";
			session.put("pay", payment);
		}else {
			payment ="クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}

	public void setCount(int count) {
		this.count=count;
	}

	public void setPay(String pay) {
		this.pay=pay;
	}

	//getter setterは必須ではない。ほかで使わなければ書かなくてもよい
	//規約で決まってるからそれに沿ってやる！


	public Map<String,Object> getSession(){
		return session;
	}

	@Override
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

//Override