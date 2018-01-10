package com.qianfeng.service;

import java.sql.SQLException;
import java.util.List;

import com.qianfeng.dao.CountCarProductdao;
import com.qianfeng.domain.CarProduct;

public class CountCarProductService {

	public CarProduct countCarProduct(String pid) throws SQLException {
		CountCarProductdao dao=new CountCarProductdao();
		return dao.countCarProduct(pid);
	
	}

}
