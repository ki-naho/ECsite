package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserDetailsDAO {

	private DBConnector db = new DBConnector();
	private Connection con =db.getConnection();

	//selectUserInfoメソッド
	public UserListDTO selectUserInfo(String loginId) throws SQLException {

		UserListDTO dto = new UserListDTO();

		String sql ="SELECT * from login_user_transaction where login_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return dto;
	}
}
