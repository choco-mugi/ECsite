package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ProductAddCompleteDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO item_info_transaction (item_name, item_price, item_stock, item_detail, insert_date) VALUES(?,?,?,?,?)";

	public void addProduct(String productName, String productPrice, String productStock, String productDetail)
			throws SQLException {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			preparedStatement.setString(2, productPrice);
			preparedStatement.setString(3, productStock);
			preparedStatement.setString(4, productDetail);
			preparedStatement.setString(5, dateUtil.getDate());

			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
