package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteConfirmAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() throws SQLException {
		String result = ERROR;

		if (session.containsKey("userlist_id")) {
			result = SUCCESS;
		}

		return result;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}