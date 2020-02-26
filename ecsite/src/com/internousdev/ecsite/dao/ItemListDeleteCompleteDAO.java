package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {

	//dao まずはDB接続
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public int deleteItemList() throws SQLException {

		String sql="DELETE FROM item_info_transaction";
		int result = 0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();//実行　result = おそらく実行した件数？

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return result; //削除した件数を返す

	}
}
