package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCompilationConfirmAction extends ActionSupport implements SessionAware {

	private String loginId;
	private String loginPass;
	private String userName;
	private String userGrade;

	public Map<String, Object> session;
	private String errorMessage;

	public String execute() {
		String result = ERROR;

		if ((loginId.equals("")) || (loginPass.equals("")) || (userName.equals("")) || (userGrade.equals(""))) {
			setErrorMessage("未入力の項目があります。");
		} else if (!((userGrade.equals("user")) || (userGrade.equals("admin")))) {
			setErrorMessage("階級に入力された値は無効です。");
		} else {
			session.put("up_loginId", loginId);
			session.put("up_loginPass", loginPass);
			session.put("up_userName", userName);
			session.put("up_userGrade", userGrade);
			result = SUCCESS;

		}

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
