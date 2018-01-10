package com.qianfeng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qianfeng.domain.CarProduct;
import com.qianfeng.utils.C3P0Utils;

public class CountCarProductdao {

	public CarProduct countCarProduct(String pid) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select shop_price from carproduct where pid=?";
		return qr.query(sql,new BeanHandler<CarProduct>(CarProduct.class), pid);
	}

}
