package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	//DBから購入履歴を取得するためのメソッド
	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id, String user_master_id) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con =db.getConnection();
		ArrayList<MyPageDTO>myPageDTO = new ArrayList<MyPageDTO>();


		//ubit= user_buy_item_transaction 長いから略してる。iitも一緒。
		//ubit.id(ubitテーブルのid) iit.item_name(iitテーブルのitem_name)という意味
		//結合するときに、どっちのテーブルのカラムなのか指定しないといけない！
		String sql="SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_Date"
				+ " FROM user_buy_item_transaction ubit"
				+ " LEFT JOIN item_info_transaction iit"
				+ " ON ubit.item_transaction_id = iit.id"
				+ " WHERE ubit.item_transaction_id=? AND ubit.user_master_id=?"
				+ " ORDER BY insert_date DESC";
		// LEFT JOIN　を用いて複数テーブルを結合することによってユーザ情報と履歴情報を紐づけて一括して取得することができる

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			ResultSet rs = ps.executeQuery();

			//取得した結果を1件ずつDTOに格納し、さらにDTOをArrayListに格納していく
			while(rs.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				myPageDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}

		return myPageDTO;
	}

	//削除するためのメソッド
	public int buyItemHistoryDelete (String item_transaction_id,String user_master_id) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql="DELETE FROM user_buy_item_transaction"
				+ " WHERE item_transaction_id=? AND user_master_id=?";

		PreparedStatement ps;
		int result =0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return result; //Actionクラスに削除した件数を返す
	}
}
