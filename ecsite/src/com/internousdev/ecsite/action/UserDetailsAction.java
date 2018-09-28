package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailsAction extends ActionSupport implements SessionAware {
	private String loginId;

	private Map<String, Object> session;

	public String execute() throws SQLException {
		String result = ERROR;
		UserListDAO userListDAO = new UserListDAO();
		UserListDTO userListDTO = new UserListDTO();
		userListDTO = userListDAO.getUserInfo(loginId);
		session.put("userlist_id", userListDTO.getId());
		session.put("userlist_login_id", userListDTO.getLoginId());
		session.put("userlist_login_pass", userListDTO.getLoginPass());
		session.put("userlist_name", userListDTO.getUserName());
		session.put("userlist_user_grade", userListDTO.getUserGrade());
		session.put("userlist_insert_date", userListDTO.getInsertDate());
		session.put("userlist_update_date", userListDTO.getUpdateDate());

		if (session.containsKey("userlist_id")) {
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

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

}
