package com.qianfeng.service;

import java.sql.SQLException;

import com.qianfeng.dao.FindOneDao;
import com.qianfeng.domain.Product;

public class FindOneService {

	public Product findOneProduct(String pid) throws SQLException {
		FindOneDao dao=new FindOneDao();
		return dao.findOneProduct(pid);
		
	}

	public void insertOneProduct(String pid, String pimage, String pname, double shop_price) throws SQLException {
		FindOneDao dao=new FindOneDao();
		dao.insertOneProduct(pid,pimage,pname,shop_price);
		
	}

}
