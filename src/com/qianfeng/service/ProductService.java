package com.qianfeng.service;

import java.sql.SQLException;

import com.qianfeng.dao.ProductDao;
import com.qianfeng.domain.Product;

public class ProductService {

	public Product findOneProduct(String pid) throws SQLException {
		ProductDao dao=new ProductDao();
		return dao.findOneProduct(pid);
		
	}

}
