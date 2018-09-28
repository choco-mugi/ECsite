package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ProductDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDeleteCompleteAction extends ActionSupport implements SessionAware {

	private String id;
	private String message;
	public Map<String, Object> session;

	ProductDeleteCompleteDAO dao = new ProductDeleteCompleteDAO();

	public String execute() throws SQLException {

		String result = ERROR;
		int res = dao.productInfoDelete(session.get("productlist_id").toString());

		if (res > 0) {
			result = SUCCESS;
			setMessage("ユーザー情報を削除しました。");
		}
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ProductDeleteCompleteDAO getDao() {
		return dao;
	}

	public void setDao(ProductDeleteCompleteDAO dao) {
		this.dao = dao;
	}

}
