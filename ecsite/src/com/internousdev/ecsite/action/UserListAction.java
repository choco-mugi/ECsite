package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private UserListDAO userListDAO = new UserListDAO();
	private ArrayList<UserListDTO> userList = new ArrayList<UserListDTO>();
	private String deleteFlg;
	private String message;
	private boolean b;

	/*session*/
	private int id;
	private String loginId;
	private String loginPass;
	private String userName;
	private String userGrade;
	private String insertDate;
	private String updateDate;

	public String execute() throws SQLException {
		if (!session.containsKey("id")) {
			return ERROR;
		}
		if (deleteFlg == null) {
			userList = userListDAO.getUserList();
			session.put("userList",userList);
			// userListが空の時、"ご登録情報はありません。"と表示。
			b = userList.isEmpty();
			if (b == true) {
				userList = null;
			}
		} else if (deleteFlg.equals("1")) {
			deleteAll();
		}
		String result = SUCCESS;
		return result;
	}

	public void deleteAll() throws SQLException {

		int res = userListDAO.userInfoDeleteAll();

		if (res > 0) {
			userList = null;
			setMessage("ユーザー情報を全て削除しました。");
		} else if (res == 0) {
			setMessage("ユーザー情報の全削除に失敗しました。");
		}

	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserListDAO getUserListDAO() {
		return userListDAO;
	}

	public void setUserListDAO(UserListDAO userListDAO) {
		this.userListDAO = userListDAO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setUserList(ArrayList<UserListDTO> userList) {
		this.userList = userList;
	}

	public ArrayList<UserListDTO> getUserList() {
		return this.userList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	/*session*/
	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
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

}
