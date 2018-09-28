package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCompilationCompleteDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();

	private String sql = "UPDATE login_user_transaction SET login_id=?, login_pass=?, user_name=?, user_grade=?, update_date=? WHERE id=?";

	public void updateUser(String loginId, String loginPass, String userName, String userGrade, String userlist_id) throws SQLException {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, loginPass);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, userGrade);
			preparedStatement.setString(5, dateUtil.getDate());
			preparedStatement.setString(6, userlist_id);

			preparedStatement.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
