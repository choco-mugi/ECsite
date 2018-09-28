package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ProductListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ProductDetailsDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ProductListDTO getProductDetail(String itemName) {

		ProductListDTO dto = new ProductListDTO();

		String sql = "SELECT * FROM item_info_transaction WHERE item_name=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, itemName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				dto.setId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setItemDetail(resultSet.getString("item_detail"));
				dto.setInsertDate(resultSet.getString("insert_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
