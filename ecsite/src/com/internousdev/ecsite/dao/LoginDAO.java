package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
					//↓メソッド名。処理内容を分かりやすくするためにgetLoginUserInfoに
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword) {

		DBConnector dbConnector =new DBConnector();
		Connection connection = dbConnector.getConnection();

		LoginDTO loginDTO = new LoginDTO();

		String sql="SELECT * FROM login_user_transaction where login_id=? AND login_pass=?";

		try {

			//セキュリティを考慮し、javaではpreparedStatementを利用する
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			//SQL文の？パラメータに指定した値を挿入することができる
			preparedStatement.setString(1,loginUserId);
			preparedStatement.setString(2, loginPassword);

			//select文のSQLを実行するメソッド。戻り値はResultSetになる
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				loginDTO.setAdminFlg(resultSet.getString("admin_flg"));

				if(resultSet.getString("login_id")!=null) {
					loginDTO.setLoginFlg(true);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return loginDTO;
	}

}
