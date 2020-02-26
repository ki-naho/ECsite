package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private Map<String,Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute() {

		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);


		/*入力値からユーザー情報の検索を行います。
		 * ログイン認証が成功した場合次の画面で商品情報が必要なため商品情報を取得します。
		 * */

		/*上記のsession.putで型がObject型に変わってしまっているため、元のLoginDTO型の記述。
		 * get("loginUser(キー）")で値(loginDTO)を取得。でその要素のgetLoginFlg()=true
		 * つまり　if(true or false){…　ってこと！！
		 **/

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()) {
			result = SUCCESS;
			//↓　これでDTOに情報入れてくる
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			session.put("item_stock", buyItemDTO.getItemStock());
			session.put("adminFlg", loginDTO.getAdminFlg());

			if(((LoginDTO)session.get("loginUser")).getAdminFlg()!=null) {

				result = "admin";

			}

			return result;
		}

		return result;
	}

		public String getLoginUserId() {
			return loginUserId;
		}

		public void setLoginUserId(String loginUserId) {
			this.loginUserId = loginUserId;
		}

		public String getLoginPassword() {
			return loginPassword;
		}

		public void setLoginPassword(String loginPassword) {
			this.loginPassword = loginPassword;
		}

		public Map<String,Object> getSession(){
			return session;
		}

		@Override
		public void setSession(Map<String,Object> session) {
			this.session=session;
		}


	}