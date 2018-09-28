package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ProductEditingConfirmAction extends ActionSupport implements SessionAware {

	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String itemDetail;
	public Map<String, Object> session;
	private String errorMessage;

	/* itemPriceとitemstockが数字か判別 */
	private static boolean isNum(String itemInt) {
		try {
			Integer.parseInt(itemInt);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public String execute() {
		String result = ERROR;

		if((itemName.equals("")) || (itemPrice.equals("")) || (itemStock.equals("")) || (itemDetail.equals(""))) {
			setErrorMessage("未入力の項目があります。");
		} else if(!(isNum(itemPrice)) || !(isNum(itemStock))) {
			setErrorMessage("在庫と値段には数字を入力してください。");
		} else {
			session.put("up_itemName", itemName);
			session.put("up_itemPrice", itemPrice);
			session.put("up_itemStock", itemStock);
			session.put("up_itemDetail",  itemDetail);
			result =SUCCESS;
		}
		return result;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
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

	public Map<String, Object> getSession() {
		return session;
	}

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
