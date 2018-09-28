package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ProductAddCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAddCompleteAction extends ActionSupport implements SessionAware {

	private String productName;
	private String productPrice;
	private String productStock;
	private String productDetail;
	public Map<String, Object> session;
	private ProductAddCompleteDAO productAddCompleteDAO = new ProductAddCompleteDAO();

	public String execute() throws SQLException {
		productAddCompleteDAO.addProduct(session.get("productName").toString(),
				session.get("productPrice").toString(),
				session.get("productStock").toString(),
				session.get("productDetail").toString());

		String result = SUCCESS;

		return result;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductStock() {
		return productStock;
	}

	public void setProductStock(String productStock) {
		this.productStock = productStock;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ProductAddCompleteDAO getProductAddCompleteDAO() {
		return productAddCompleteDAO;
	}

	public void setProductAddCompleteDAO(ProductAddCompleteDAO productAddCompleteDAO) {
		this.productAddCompleteDAO = productAddCompleteDAO;
	}



}
