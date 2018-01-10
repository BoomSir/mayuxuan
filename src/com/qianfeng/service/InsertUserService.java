package com.qianfeng.service;

import java.sql.SQLException;

import com.qianfeng.dao.InsertUserDao;
import com.qianfeng.domain.User;

public class InsertUserService {

	public void InsertUser(String uid,String username,String userpassword,String realname,String email,
			String telephone) throws SQLException {
				
			InsertUserDao dao=new InsertUserDao();
			dao.InsertUser(uid,username,userpassword,realname,email,telephone);
		 
	}

}
