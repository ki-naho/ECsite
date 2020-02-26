package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.util.DBConnector;

public class UserCreateConfirmDAO {

	//DB接続
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public boolean isExistUser (String loginUserId) {
		/* SQL文　件数の取得
		 * SELECT COUNT(対象とするカラム名) AS COUNT(件数の名前になる<Int型>) FROM テーブル名 WHERE 条件
		 * */
		String sql = "select count(*) AS COUNT FROM login_user_transaction where login_id=?";
		boolean result =false;

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,  loginUserId);

			ResultSet resultSet = preparedStatement.executeQuery();//実行

			/* SELECT文では必ず必要。データ取れてきたか取れてないかの確認になる
			 * SELECTした値が何なのかを知りたいときはsetする！！
			 * 今回は、0か1か（あるかないか）の問題だから、setする必要がない。
			 * */
			if(resultSet.next()) {
				//件数があるなら true
				if(resultSet.getInt("COUNT")>0 ) {
					result = true;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
