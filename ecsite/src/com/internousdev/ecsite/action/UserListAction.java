package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private List<UserListDTO> userListDTOList = new ArrayList<UserListDTO>();

	public String execute() throws SQLException{


		UserListDAO dao = new UserListDAO();
		userListDTOList = dao.selectUserList();

		if (!(userListDTOList.size() >0)) {
			userListDTOList = null;
		}

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

	public List<UserListDTO> getUserListDTOList (){
		return userListDTOList;
	}

	public void setUserListDTOList(List<UserListDTO> userListDTOList) {
		this.userListDTOList=userListDTOList;
	}

}