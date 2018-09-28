package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ProductListDAO;
import com.internousdev.ecsite.dto.ProductListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private ProductListDAO productListDAO = new ProductListDAO();
	private ArrayList<ProductListDTO> productList = new ArrayList<ProductListDTO>();
	private String deleteFlg;
	private String message;
	private boolean b;

	/*session*/
	private int id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String itemDetail;
	private String insertDate;
	private String updateDate;


	public String execute() throws SQLException {
		if (!session.containsKey("id")) {
			return ERROR;
		}
		if (deleteFlg == null) {
			productList = productListDAO.getProductList();
			// userListが空の時、"ご登録情報はありません。"と表示。
			b = productList.isEmpty();
			if (b == true) {
				productList = null;
			}
		} else if (deleteFlg.equals("1")) {
			deleteAll();
		}
		String result = SUCCESS;
		return result;
	}

	public void deleteAll() throws SQLException {

		int res = productListDAO.productInfoDeleteAll();

		if (res > 0) {
			productList = null;
			setMessage("商品情報を全て削除しました。");
		} else if (res == 0) {
			setMessage("商品情報の全削除に失敗しました。");
		}
	}

	public ProductListDAO getProductListDAO() {
		return productListDAO;
	}

	public void setProductListDAO(ProductListDAO productListDAO) {
		this.productListDAO = productListDAO;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setProductList(ArrayList<ProductListDTO> productList) {
		this.productList = productList;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ProductListDTO> getProductList() {
		return this.productList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
