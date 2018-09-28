package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAddConfirmAction extends ActionSupport implements SessionAware {

	private String productName;
	private String productPrice;
	private String productStock;
	private String productDetail;
	public Map<String, Object> session;
	private String errorMessage;


	/* productPriceとProductStockが数字か判別 */
	private static boolean isNum(String productint) {
		try {
			Integer.parseInt(productint);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public String execute() {
		String result = ERROR;

		if ((productName.equals("")) || (productPrice.equals("")) || (productStock.equals(""))
				|| (productDetail.equals(""))) {
			setErrorMessage("未入力の項目があります。");
		} else if (!(isNum(productPrice)) || !(isNum(productStock))) {
			setErrorMessage("在庫と値段には数字を入力してください。");
		} else {
			session.put("productName", productName);
			session.put("productPrice", productPrice);
			session.put("productStock", productStock);
			session.put("productDetail", productDetail);
			result = SUCCESS;
		}

		/*
		 * if(!(productName.equals("")) && !(productPrice.equals("")) &&
		 * !(productStock.equals("")) && !(productDetail.equals(""))
		 * prductPriceとproductStockが数字のとき && isNum(productPrice) &&
		 * isNum(productStock)) { session.put("productName", productName);
		 * session.put("productPrice", productPrice);
		 * session.put("productStock", productStock);
		 * session.put("productDetail", productDetail); } else {
		 * setErrorMessage("未入力の項目があります。"); result = ERROR; }
		 */
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
