package com.qianfeng.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import com.qianfeng.domain.Admin;
import com.qianfeng.utils.C3P0Utils;

public class findUserDao {

	public Admin findUser(String username) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from adminer where username=?";
		return qr.query(sql, new BeanHandler<Admin>(Admin.class), username);
		
	}

	public Admin findUser(String username, String password) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from adminer where username=? and password=?";
		return qr.query(sql, new BeanHandler<Admin>(Admin.class), username,password);
	}

}
