package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ProductListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ProductListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<ProductListDTO> getProductList() throws SQLException {
		ArrayList<ProductListDTO> productListDTO = new ArrayList<ProductListDTO>();
		String sql = "SELECT * FROM item_info_transaction ORDER BY insert_date ASC";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				ProductListDTO dto = new ProductListDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setItemDetail(resultSet.getString("item_detail"));
				dto.setInsertDate(resultSet.getString("insert_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				productListDTO.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return productListDTO;
	}

	public int productInfoDeleteAll() throws SQLException{

		String sql = "DELETE FROM item_info_transaction";

		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);

			result = preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return result;
	}

}
