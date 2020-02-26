package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	public int buyItemInfo(String item_transaction_id,String total_price,String total_count,String user_master_id,String pay)throws SQLException {

		DBConnector db=new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		String sql = "INSERT INTO user_buy_item_transaction (item_transaction_id,total_price,total_count,user_master_id,pay,insert_date)VALUES(?,?,?,?,?,?)";

		int result =0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, dateUtil.getDate());
			result = ps.executeUpdate(); //resultには更新件数？
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return result;
	}

	/* <<購入したら在庫が減るようにする>>
	 * insert文のメソッド　↑をint型にして、0か1以上(更新件数)を返すようにする。　
	 * insertできたら(Actionファイルを参考・if(insertメソッド>0) ｛　update文のメソッド↓を実行する
	 * */


	public void updateItemInfo(int count,String id) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();

														//在庫= 元の在庫 - ?(購入数)
		String sql ="UPDATE item_info_transaction SET item_stock = item_stock -?, update_date =?  WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setString(2, dateUtil.getDate());
			ps.setString(3, id);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	}
}
