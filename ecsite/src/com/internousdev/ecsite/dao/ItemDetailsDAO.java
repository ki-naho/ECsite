package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;


public class ItemDetailsDAO {

	//DB接続
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	//selectItemInfoメソッド　idをもとに商品情報をselectしてくる
	public ItemListDTO selectItemInfo(String id) throws SQLException{
		ItemListDTO dto =new ItemListDTO();

		String sql ="SELECT * FROM item_info_transaction WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setNumber(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return dto;

	}

}
