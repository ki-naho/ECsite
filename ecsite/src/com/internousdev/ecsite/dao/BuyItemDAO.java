package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	public BuyItemDTO getBuyItemInfo() {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		BuyItemDTO buyItemDTO = new BuyItemDTO();

		//商品情報をすべて取得するSQL文
		String sql = "SELECT id,item_name,item_price,item_stock FROM item_info_transaction";

		try {

			//これpreparedStatement使わない時でも必要らしい。
			PreparedStatement preparedStatement=connection.prepareStatement(sql);

			//ResultSetインターフェース：データベースの結果セットを表すデータのテーブル。実行で生成される。
			ResultSet resultSet = preparedStatement.executeQuery();//実行のメソッド。戻り値はResultset

			if(resultSet.next()) {

				//DBから取得した情報をDTOクラスに格納。buyItemDTOクラスのsetterを利用する
			//  DTO(箱に）　　.setどこに(なにを)
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				buyItemDTO.setItemStock(resultSet.getString("item_stock"));
			}

			//例外処理
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buyItemDTO;
	}

	public BuyItemDTO selectItemName(String id) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		BuyItemDTO dto = new BuyItemDTO();

		String sql ="SELECT item_name FROM item_info_transaction WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();//実行のメソッド。戻り値はResultset

			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
