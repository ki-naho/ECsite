package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDetailsDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailsAction extends ActionSupport implements SessionAware{

	private String loginId;
	private Map<String,Object> session;
	private UserListDTO userDetailsDTO = new UserListDTO();

	public String execute() throws SQLException {

		UserDetailsDAO dao =new UserDetailsDAO();
		userDetailsDTO = dao.selectUserInfo(loginId);

		if(userDetailsDTO.getLoginId() ==null) {
			userDetailsDTO = null;
		}

		String result = SUCCESS;
		return result;
	}
	public String getLoginId () {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId= loginId;
	}

	public UserListDTO getUserDetailsDTO() {
		return userDetailsDTO;
	}

	public void setUserDetailsDTO (UserListDTO userDetailsDTO) {
		this.userDetailsDTO = userDetailsDTO;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}
