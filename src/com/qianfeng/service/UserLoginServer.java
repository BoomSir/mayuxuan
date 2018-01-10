package com.qianfeng.service;

import java.sql.SQLException;

import com.qianfeng.dao.findUserDao;
import com.qianfeng.domain.Admin;

public class UserLoginServer {

	public Admin findUser(String username) throws SQLException {
		findUserDao dao=new findUserDao();
		return dao.findUser(username);
	}

	public Admin findUser(String username, String password) throws SQLException {
		findUserDao dao=new findUserDao();
		return dao.findUser(username,password);
	}

}
