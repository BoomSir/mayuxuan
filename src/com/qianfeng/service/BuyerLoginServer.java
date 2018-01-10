package com.qianfeng.service;

import java.sql.SQLException;

import com.qianfeng.dao.findBuyerDao;
import com.qianfeng.dao.findUserDao;
import com.qianfeng.domain.Admin;

public class BuyerLoginServer {

	public Admin findBuyer(String username) throws SQLException {
		findBuyerDao dao=new findBuyerDao();
		return dao.findBuyer(username);
	}

	public Admin findUser(String username, String password) throws SQLException {
		findBuyerDao dao=new findBuyerDao();
		return dao.findBuyer(username,password);
	}

}
