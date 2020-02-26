package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserDeleteCompleteDAO {

	private DBConnector db= new DBConnector();
	private Connection con = db.getConnection();

	public int deleteUserInfo(String loginId) throws SQLException {

		int result = 0;
		String sql ="DELETE FROM login_user_transaction WHERE login_id=?";


		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);

			result = ps.executeUpdate(); //更新件数をセット

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return result;
	}

}
