package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	private List<UserListDTO> UserListDTOList = new ArrayList<UserListDTO>();


	public List<UserListDTO> selectUserList() throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();//DB接続

		String sql="SELECT * FROM login_user_transaction ORDER BY id ASC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();//select文の実行


			//while文の中にインスタンス化をすることで、そのたびに新しい箱が生成される。
			//while文の中に入れないと、上書きされちゃう！
			while (rs.next()) {
				UserListDTO dto = new UserListDTO();
				dto.setId(rs.getString("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));
				UserListDTOList.add(dto);
			}

			if(UserListDTOList.size()<=0) {
				UserListDTO dto = new UserListDTO();
				dto.setId("該当なし");
				dto.setLoginId("該当なし");
				dto.setPassword("該当なし");
				dto.setUserName("該当なし");
				dto.setInsert_date("該当なし");
				dto.setUpdate_date(rs.getString("該当なし"));
				UserListDTOList.add(dto);
			}


		} catch (SQLException e){
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UserListDTOList;
	}
}