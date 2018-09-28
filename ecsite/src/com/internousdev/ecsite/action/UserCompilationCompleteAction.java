package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCompilationCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCompilationCompleteAction extends ActionSupport implements SessionAware {

	private String loginId;
	private String loginPass;
	private String userName;
	private String userGrade;
	private String userlist_id;
	public Map<String, Object> session;
	private UserCompilationCompleteDAO userCompilationCompleteDAO = new UserCompilationCompleteDAO();

	public String execute() throws SQLException {

		userCompilationCompleteDAO.updateUser(session.get("up_loginId").toString(), session.get("up_loginPass").toString(),
				session.get("up_userName").toString(), session.get("up_userGrade").toString(),session.get("userlist_id").toString());

		String result = SUCCESS;

		return result;
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

	public String getUserlist_id() {
		return userlist_id;
	}

	public void setUserlist_id(String userlist_id) {
		this.userlist_id = userlist_id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserCompilationCompleteDAO getUserCompilationCompleteDAO() {
		return userCompilationCompleteDAO;
	}

	public void setUserCompilationCompleteDAO(UserCompilationCompleteDAO userCompilationCompleteDAO) {
		this.userCompilationCompleteDAO = userCompilationCompleteDAO;
	}

}
