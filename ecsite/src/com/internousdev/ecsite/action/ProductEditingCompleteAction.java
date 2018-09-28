package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ProductEditingCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductEditingCompleteAction extends ActionSupport implements SessionAware {

	private String itemName;
	private String itemmPrice;
	private String itemStock;
	private String itemDetail;
	private String productListId;

	public Map<String, Object> session;
	private ProductEditingCompleteDAO productEditingCompleteDAO = new ProductEditingCompleteDAO();

	public String execute() throws SQLException {

		productEditingCompleteDAO.updateProduct(session.get("up_itemName").toString(), session.get("up_itemPrice").toString(),
				session.get("up_itemStock").toString(), session.get("up_itemDetail").toString(),
				session.get("productlist_id").toString());

		String result = SUCCESS;

		return result;

	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemmPrice() {
		return itemmPrice;
	}

	public void setItemmPrice(String itemmPrice) {
		this.itemmPrice = itemmPrice;
	}

	public String getItemStock() {
		return itemStock;
	}

	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public String getProductListId() {
		return productListId;
	}

	public void setProductListId(String productListId) {
		this.productListId = productListId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ProductEditingCompleteDAO getProductEditingCompleteDAO() {
		return productEditingCompleteDAO;
	}

	public void setProductEditingCompleteDAO(ProductEditingCompleteDAO productEditingCompleteDAO) {
		this.productEditingCompleteDAO = productEditingCompleteDAO;
	}

}
