package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {

	//dao まずはDB接続
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public int deleteUserList() throws SQLException {

		String sql="DELETE FROM login_user_transaction WHERE admin_flg IS null";
		int result = 0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();//実行

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return result; //削除した件数を返す

	}
}
