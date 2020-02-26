package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemUpdateCompleteDAO {


	public int itemUpdate(String reItemName,String reItemPrice,String reItemNumber,String id) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();

		int result = 0;
		String sql ="UPDATE item_info_transaction SET item_name=?, item_price=?, item_stock=?, update_date=? WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reItemName);
			ps.setString(2, reItemPrice);
			ps.setString(3, reItemNumber);
			ps.setString(4, dateUtil.getDate());
			ps.setString(5, id);
			result=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return result;
	}
}
