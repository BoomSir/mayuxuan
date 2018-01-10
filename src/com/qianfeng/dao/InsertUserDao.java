package com.qianfeng.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.qianfeng.domain.User;
import com.qianfeng.utils.C3P0Utils;

public class InsertUserDao {

	public void InsertUser(String uid,String username, String userpassword, String realname, String email, String telephone) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="insert into shoppinguser values(?,?,?,?,?,?)";
		qr.update(sql,uid,username,userpassword,realname,email,telephone);
		 
	}

}
