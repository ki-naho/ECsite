package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {

	private List<ItemListDTO> itemListDTOList = new ArrayList<ItemListDTO>();


	public List<ItemListDTO> selectItemList() throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();//DB接続

		String sql="SELECT * FROM item_info_transaction ORDER BY id ASC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();//select文の実行


			//while文の中にインスタンス化をすることで、そのたびに新しい箱が生成される。
			//while文の中に入れないと、上書きされちゃう！
			while (rs.next()) {
				ItemListDTO dto = new ItemListDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setNumber(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));
				itemListDTOList.add(dto);
			}

			if(itemListDTOList.size()<=0) {
				ItemListDTO dto = new ItemListDTO();
				dto.setId("該当なし");
				dto.setItemName("該当なし");
				dto.setItemPrice("該当なし");
				dto.setNumber("該当なし");
				dto.setInsert_date("該当なし");
				dto.setUpdate_date("該当なし");
				itemListDTOList.add(dto);
			}


		} catch (SQLException e){
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemListDTOList;
	}
}

// 例外を投げました？質問しよう～
