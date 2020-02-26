package com.internousdev.ecsite.dto;

public class LoginDTO {

	//属性。
	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg = false;
	private String adminFlg;

	/* 第三者に教えてあげるメソッド。()の中身必要ない
	 * ゲッターの場合は、そのプロパティの型。何かしらを返す
	 * だから　return*/

	public String getLoginId() {
		return loginId;
	}


	/*　セットするだけだから、戻り値がない。 void*/
	public void setLoginId(String loginId) {
		this.loginId=loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword=loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName=userName;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg=loginFlg;
	}

	public String getAdminFlg() {
		return adminFlg;
	}

	public void setAdminFlg(String adminFlg) {
		this.adminFlg=adminFlg;
	}

}