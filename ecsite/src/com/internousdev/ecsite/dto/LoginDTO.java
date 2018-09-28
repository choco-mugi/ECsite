package com.internousdev.ecsite.dto;

public class LoginDTO {

	private String loginId;
	private String loginPassword;
	private String userName;
	private String userGrade;
	private boolean loginFlg = false;
	private boolean adminFlg = false;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId=loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword=loginPassword;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg=loginFlg;
	}

	public boolean getAdminFlg() {
		return adminFlg;
	}

	public void setAdminFlg(boolean adminFlg) {
		this.adminFlg = adminFlg;
	}



}