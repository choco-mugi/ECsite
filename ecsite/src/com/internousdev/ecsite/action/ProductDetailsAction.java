package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ProductDetailsDAO;
import com.internousdev.ecsite.dto.ProductListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware {
	private String itemName;

	private Map<String, Object> session;

	public String execute() throws SQLException {
		String result = ERROR;
		ProductDetailsDAO productDetailsDAO = new ProductDetailsDAO();
		ProductListDTO productListDTO = new ProductListDTO();
		productListDTO = productDetailsDAO.getProductDetail(itemName);
		session.put("productlist_id", productListDTO.getId());
		session.put("productlist_item_name", productListDTO.getItemName());
		session.put("productlist_item_price", productListDTO.getItemPrice());
		session.put("productlist_item_stock", productListDTO.getItemStock());
		session.put("productlist_item_detail", productListDTO.getItemDetail());
		session.put("productlist_insert_date", productListDTO.getInsertDate());
		session.put("productlist_update_date", productListDTO.getUpdateDate());

		if(session.containsKey("productlist_item_name")) {
			result = SUCCESS;
		}

		return result;

	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
