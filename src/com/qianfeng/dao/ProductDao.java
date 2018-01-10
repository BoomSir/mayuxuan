package com.qianfeng.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qianfeng.domain.Product;
import com.qianfeng.utils.C3P0Utils;

public class ProductDao {

	public Product findOneProduct(String pid) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from product where pid=?";
		return qr.query(sql, new BeanHandler<Product>(Product.class),pid);
	}

}
