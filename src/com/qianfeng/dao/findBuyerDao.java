package com.qianfeng.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qianfeng.domain.Admin;
import com.qianfeng.utils.C3P0Utils;

public class findBuyerDao {

	public Admin findBuyer(String username) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from shoppinguser where username=?";
		return qr.query(sql, new BeanHandler<Admin>(Admin.class), username);
	}

	public Admin findBuyer(String username, String password) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from shoppinguser where username=? and userpassword=?";
		return qr.query(sql, new BeanHandler<Admin>(Admin.class), username,password);
	}

}
